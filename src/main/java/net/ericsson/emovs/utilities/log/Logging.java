package net.ericsson.emovs.utilities.log;

import android.util.Log;

public class Logging {
   private static final String TAG = "Logging Lib: ";
   private static final boolean LOG_ENABLED = true; //BuildConfig.DEBUG;

   public static void d(String msg) {
      if (LOG_ENABLED) {
         Log.d(TAG, TAG + msg);
      }
   }

   // Report to server
//   public static void e(String title, Exception ex, boolean isReportToServer) {
//      if (BuildConfig.DEBUG) {
//         Log.e(TAG, TAG + title + ex.toString());
//      }
//
//      if (isReportToServer) {
//         Crashlytics.getInstance().core.logException(ex);
//      }
//   }

   public static void e(String title, Exception ex) {
      if (LOG_ENABLED) {
         Log.e(TAG, TAG + title + ex.toString());
      }
   }

   public static void e(String text) {
      if (LOG_ENABLED) {
         Log.e(TAG, TAG + text);
      }
   }

   public static void i(String msg) {
      if (LOG_ENABLED) {
         Log.i(TAG, TAG + msg);
      }
   }

   public static void v(String msg) {
      if (LOG_ENABLED) {
         Log.v(TAG, TAG + msg);
      }
   }
}
