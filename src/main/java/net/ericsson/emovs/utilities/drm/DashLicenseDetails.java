package net.ericsson.emovs.utilities.drm;

import android.util.Log;
import android.util.Pair;

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

public class DashLicenseDetails {
    private static final String TAG = DashLicenseDetails.class.toString();

    public static Pair<String, String> getLicenseDetails(String manifestUrl, boolean isOffline) {
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
            }
            else {
                return null;
            }

            return new Pair<>(drmLicenseUrl, drmInitializationBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
