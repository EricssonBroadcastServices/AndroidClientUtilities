package net.ericsson.emovs.utilities;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by Joao Coelho on 2017-10-05.
 */

public class ServiceUtils {
    public static boolean isServiceRunning(Context ctx, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
