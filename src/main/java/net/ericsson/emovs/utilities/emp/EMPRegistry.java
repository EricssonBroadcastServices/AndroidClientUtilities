package net.ericsson.emovs.utilities.emp;

import android.content.Context;

/**
 * Created by Joao Coelho on 2017-10-24.
 */

public class EMPRegistry {
    private static Context context;
    private static String businessUnit;
    private static String customer;
    private static String apiUrl;

    public static void bindApplicationContext(Context newContext) {
        context = newContext;
    }

    public static void bindExposureContext(String _apiUrl, String _customer, String _businessUnit) {
        apiUrl = _apiUrl;
        customer = _customer;
        businessUnit = _businessUnit;
    }

    public static Context applicationContext() {
        return context;
    }

    public static String apiUrl() {
        return apiUrl;
    }

    public static String customer() {
        return customer;
    }

    public static String businessUnit() {
        return businessUnit;
    }

}
