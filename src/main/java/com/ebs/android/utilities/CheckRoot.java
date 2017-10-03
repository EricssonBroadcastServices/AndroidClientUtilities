package com.ebs.android.utilities;

import net.ericsson.emovs.utilities.Logging;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Joao Coelho on 2017-10-03.
 */

public class CheckRoot {
    private static final String TAG = CheckRoot.class.getName();

    public static boolean isDeviceRooted() {
        if (checkDeviceDebuggable() || checkSuperuserApk() || checkRootPathSU() || checkAccessRootData() || checkGetRootAuth()) {
            return true;
        }

        return false;
    }

    // check buildTags
    private static boolean checkDeviceDebuggable() {
        String buildTags = android.os.Build.TAGS;
        if (buildTags != null && buildTags.contains("test-keys")) {
            Logging.d(TAG + "buildTags = " + buildTags);
            return true;
        }
        return false;
    }

    // Superuser.apk
    private static boolean checkSuperuserApk() {
        try {
            File file = new File("/system/app/Superuser.apk");
            if (file.exists()) {
                Logging.d(TAG + "/system/app/Superuser.apk exist");
                return true;
            }
        } catch (Exception e) {
            Logging.e(TAG + e.toString());
        }
        return false;
    }

    // find su in some path
    private static boolean checkRootPathSU() {
        final String kSuSearchPaths[] = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        try {
            for (String path : kSuSearchPaths) {
                if (new File(path + "su").exists()) {
                    Logging.d(TAG + "find su in : " + path);
                    return true;
                }
            }
        } catch (Exception e) {
            Logging.e(TAG + e.toString());
        }
        return false;
    }

    // Check /data
    private static synchronized boolean checkAccessRootData() {
        try {
            Logging.d(TAG + "to write /data");
            String fileContent = "test_ok";
            Boolean writeFlag = writeFile("/data/su_test", fileContent);
            if (writeFlag) {
                Logging.d(TAG + "write ok");
            } else {
                Logging.d(TAG + "write failed");
            }

            Logging.d(TAG + "to read /data");
            String strRead = readFile("/data/su_test");
            Logging.d(TAG + "strRead=" + strRead);
            return fileContent.equals(strRead);

        } catch (Exception e) {
            Logging.e(TAG + "Unexpected error - Here is what I know: " + e.getMessage());
            return false;
        }
    }

    private static Boolean writeFile(String fileName, String message) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            byte[] bytes = message.getBytes();
            fout.write(bytes);
            fout.close();
            return true;

        } catch (Exception e) {
            Logging.e(TAG + e.toString());
            return false;
        }
    }

    private static String readFile(String fileName) {
        File file = new File(fileName);
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            while ((len = fis.read(bytes)) > 0) {
                bos.write(bytes, 0, len);
            }
            String result = new String(bos.toByteArray());
            Logging.d(TAG + result);
            return result;

        } catch (Exception e) {
            Logging.e(TAG + e.toString());
            return null;
        }
    }

    // exec su
    private static synchronized boolean checkGetRootAuth() {
        Process process = null;
        DataOutputStream os = null;
        try {
            Logging.d(TAG + "to exec su");
            process = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(process.getOutputStream());
            os.writeBytes("exit\n");
            os.flush();
            int exitValue = process.waitFor();
            Logging.d(TAG + "exitValue=" + exitValue);
            return exitValue == 0;

        } catch (Exception e) {
            Logging.e(TAG + "Unexpected error - Here is what I know: " + e.getMessage());
            return false;

        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (Exception e) {
                Logging.e(TAG + e.toString());
            }
        }
    }
}