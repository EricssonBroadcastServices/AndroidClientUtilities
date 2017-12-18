package net.ericsson.emovs.utilities.system;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;

import net.ericsson.emovs.utilities.log.Logging;

import java.io.Serializable;

import static android.provider.Settings.Secure.ANDROID_ID;
import static android.provider.Settings.Secure.getString;

public class DeviceInfo implements Serializable {
    private static final double TABLET_SIZE_TRESHOLD = 7;
    private static final String FALLBACK_ID = "AndroidId";
    
    public String deviceId;
    public int height;
    public int width;
    public String model;
    public String name;
    public String os;
    public String osVersion;
    public String manufacturer;
    public String type;
    
    private static String getDeviceId(ContentResolver resolver) {
        try {
            String android_id = getString(resolver, ANDROID_ID);
            if (android_id == null) {
                if (Build.class.getDeclaredMethod("getSerial") != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                        android_id = Build.getSerial();
                    }
                }
            }
            if (android_id == null) {
                android_id = FALLBACK_ID;
            }
            return android_id;
        }
        catch (Exception e) {
           Logging.e("Error getting device id: " + e.toString());
            return FALLBACK_ID;
        }
    }

    private static boolean diagonalLargerThanSize(double width, double height, double diagonalTreshold) {
        Logging.v(String.format("Width %f\" Height %f\" Diagonal Treshold %f\"",width, height, diagonalTreshold));
        return width*width + height*height > diagonalTreshold*diagonalTreshold;
    }

    public static DeviceInfo collect(Context context) {
        DeviceInfo info = new DeviceInfo();
        info.model = Build.MODEL;
        info.manufacturer = Build.MANUFACTURER;
        info.deviceId = getDeviceId(context.getContentResolver());
        info.os = "Android";
        info.osVersion = Build.VERSION.RELEASE;
        
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        info.width = metrics.widthPixels;
        info.height = metrics.heightPixels;
        
        boolean isTablet = diagonalLargerThanSize(info.width/metrics.xdpi, info.height/metrics.ydpi, TABLET_SIZE_TRESHOLD);
        info.type = isTablet ? "TABLET" : "MOBILE";
        
        return info;
    }

}
