package net.ericsson.emovs.utilities.emp;

import android.net.Uri;

/**
 * Created by Joao Coelho on 2018-02-02.
 */

public class UniversalPackagerHelper {

    public static boolean isUniversalPackager(String manfestUrl) {
        return manfestUrl != null && manfestUrl.contains(".isml");
    }

    public static boolean isStaticCatchup(String manifestUrl) {
        Uri manifest = Uri.parse(manifestUrl);
        if (manifest == null) {
            return false;
        }
        String paramT = manifest.getQueryParameter("t");
        if (paramT == null) {
            return false;
        }
        return paramT.split("-").length == 6;
    }

    public static boolean isDynamicCatchup(String manifestUrl){
        Uri manifest = Uri.parse(manifestUrl);
        if (manifest == null) {
            return false;
        }
        return !isStaticCatchup(manifestUrl);
    }
}
