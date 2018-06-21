package net.ericsson.emovs.utilities.drm;

import android.util.Log;
import android.util.Pair;

import net.ericsson.emovs.utilities.system.ParameterizedRunnable;
import net.ericsson.emovs.utilities.system.RunnableThread;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;

/**
 * Created by Joao Coelho on 2017-11-21.
 */

public class DashDetails {
    private static final String TAG = DashDetails.class.toString();

    public static void isValidManifest(final String manifestUrl, final boolean isOffline, final Runnable onValid, final ParameterizedRunnable<String> onInvalid, final Runnable onHttpRequired) {
        new RunnableThread(new Runnable() {
            @Override
            public void run() {
                final int MAX_RETRIES = 5;
                String innerManifestUrl = manifestUrl;
                Document mpd = null;
                for (int i = 0; i < MAX_RETRIES; ++i) {
                    if (i == 3) {
                        innerManifestUrl = innerManifestUrl.replace("https://", "http://");
                    }
                    try {
                        XPath xpath = XPathFactory.newInstance().newXPath();
                        if(isOffline) {
                            mpd = getManifestDocument(new File(manifestUrl));
                        }
                        else {
                            mpd = getManifestDocument(new URL(manifestUrl));
                        }
                        NodeList sets = (NodeList) xpath.compile("//urn:mpeg:dash:schema:mpd:2011:AdaptationSet").evaluate(mpd, XPathConstants.NODESET);

                        if (sets.getLength() == 0) {
                            if (onInvalid != null) onInvalid.run(mpd == null ? "MPD could not be reached." : mpd.toString());
                        }
                        else if (i < 3) {
                            if (onValid != null) onValid.run();
                        }
                        else {
                            if (onHttpRequired != null) onHttpRequired.run();
                        }
                        return;
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (onInvalid != null) {
                    onInvalid.run(mpd == null ? "MPD could not be reached." : mpd.toString());
                }
            }
        }).start();
    }

    public static void getLicenseDetailsVemup(final String manifestUrl, final boolean isOffline, final ParameterizedRunnable<Pair<String, String>> onDetails) {
        new RunnableThread(new Runnable() {
            @Override
            public void run() {
                try {
                    XPath xpath = XPathFactory.newInstance().newXPath();
                    Document mpd = null;
                    if(isOffline) {
                        mpd = getManifestDocument(new File(manifestUrl));
                    }
                    else {
                        mpd = getManifestDocument(new URL(manifestUrl));
                    }
                    NodeList laurls = (NodeList) xpath.compile("//urn:mpeg:cenc:2013:pssh").evaluate(mpd, XPathConstants.NODESET);
                    Log.d(TAG, "Node Count: " + laurls.getLength());
                    String drmLicenseUrl = null;
                    String drmInitializationBase64 = null;
                    if (laurls.getLength() > 0) {
                        Node laurl = laurls.item(0);
                        drmInitializationBase64 = laurl.getTextContent();
                        Log.d(TAG, "DRM Init Data: " + drmInitializationBase64);

                        if (onDetails != null) {
                            onDetails.run(new Pair<>(drmLicenseUrl, drmInitializationBase64));
                        }
                    }
                    else {
                        if (onDetails != null) {
                            onDetails.run(null);
                        }
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (onDetails != null) {
                    onDetails.run(null);
                }
            }
        }).start();
    }

    public static void getLicenseDetails(final String manifestUrl, final boolean isOffline, final ParameterizedRunnable<Pair<String, String>> onDetails) {
        new RunnableThread(new Runnable() {
            @Override
            public void run() {
                try {
                    XPath xpath = XPathFactory.newInstance().newXPath();
                    Document mpd = null;
                    if(isOffline) {
                        mpd = getManifestDocument(new File(manifestUrl));
                    }
                    else {
                        mpd = getManifestDocument(new URL(manifestUrl));
                    }
                    NodeList laurls = (NodeList) xpath.compile("//urn:microsoft:laurl").evaluate(mpd, XPathConstants.NODESET);
                    Log.d(TAG, "Node Count: " + laurls.getLength());
                    String drmLicenseUrl = null;
                    String drmInitializationBase64 = null;
                    if (laurls.getLength() > 0) {
                        Node laurl = laurls.item(0);
                        NamedNodeMap laurlAttrs = laurl.getAttributes();
                        Node licenseServerUrlNode = laurlAttrs.getNamedItem("licenseUrl");
                        drmLicenseUrl = licenseServerUrlNode.getNodeValue();
                        Log.d(TAG, "License Server URL: " + drmLicenseUrl);

                        NodeList psshCandidates = laurl.getParentNode().getChildNodes();
                        for (int j = 0; j < psshCandidates.getLength(); ++j) {
                            Node pssh = psshCandidates.item(j);
                            if (pssh.getNodeName().contains("pssh")) {
                                drmInitializationBase64 = pssh.getTextContent();
                                Log.d(TAG, "EMP Initialization Data: " + drmInitializationBase64);
                                break;
                            }
                        }
                        if (onDetails != null) {
                            onDetails.run(new Pair<>(drmLicenseUrl, drmInitializationBase64));
                        }
                    }
                    else {
                        if (onDetails != null) {
                            onDetails.run(null);
                        }
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (onDetails != null) {
                    onDetails.run(null);
                }
            }
        }).start();
    }

    private static Document getManifestDocument(File manifestFile) throws Exception {
        String manifestContent = FileUtils.readFileToString(manifestFile, "UTF-8");

        Log.d(TAG, manifestContent);

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(manifestContent.getBytes()));
        return doc;
    }

    private static Document getManifestDocument(URL manifestUrl) throws Exception {
        File temp = File.createTempFile(UUID.randomUUID().toString(), ".mpd");
        FileUtils.copyURLToFile(manifestUrl, temp);
        return getManifestDocument(temp);
    }
}
