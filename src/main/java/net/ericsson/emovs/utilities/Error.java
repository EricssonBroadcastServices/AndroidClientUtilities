package net.ericsson.emovs.utilities;

/*
 * Copyright (c) 2017 Ericsson. All Rights Reserved
 *
 * This SOURCE CODE FILE, which has been provided by Ericsson as part
 * of an Ericsson software product for use ONLY by licensed users of the
 * product, includes CONFIDENTIAL and PROPRIETARY information of Ericsson.
 *
 * USE OF THIS SOFTWARE IS GOVERNED BY THE TERMS AND CONDITIONS OF
 * THE LICENSE STATEMENT AND LIMITED WARRANTY FURNISHED WITH
 * THE PRODUCT.
 */

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class Error {
    public static final Error NETWORK_ERROR = new Error("NETWORK_ERROR");
    public static final Error DEVICE_LIMIT_EXCEEDED = new Error("DEVICE_LIMIT_EXCEEDED");
    public static final Error SESSION_LIMIT_EXCEEDED = new Error("SESSION_LIMIT_EXCEEDED");
    public static final Error UNKNOWN_DEVICE_ID = new Error("UNKNOWN_DEVICE_ID");
    public static final Error INVALID_JSON = new Error("INVALID_JSON");
    public static final Error INCORRECT_CREDENTIALS = new Error("INCORRECT_CREDENTIALS");
    public static final Error UNKNOWN_BUSINESS_UNIT = new Error("UNKNOWN_BUSINESS_UNIT");
    public static final Error NO_SESSION_TOKEN = new Error("NO_SESSION_TOKEN");
    public static final Error INVALID_SESSION_TOKEN = new Error("INVALID_SESSION_TOKEN");
    public static final Error UNKNOWN_ASSET = new Error("UNKNOWN_ASSET");
    public static final Error NOT_ENTITLED = new Error("NOT_ENTITLED");
    public static final Error DEVICE_BLOCKED = new Error("DEVICE_BLOCKED");
    public static final Error GEO_BLOCKED = new Error("GEO_BLOCKED");
    public static final Error LICENSE_EXPIRED = new Error("LICENSE_EXPIRED");
    public static final Error NOT_ENABLED = new Error("NOT_ENABLED");
    public static final Error DOWNLOAD_TOTAL_LIMIT_REACHED = new Error("DOWNLOAD_TOTAL_LIMIT_REACHED");
    public static final Error DOWNLOAD_ASSET_LIMIT_REACHED = new Error("DOWNLOAD_ASSET_LIMIT_REACHED");
    public static final Error ALREADY_DOWNLOADED = new Error("ALREADY_DOWNLOADED");
    public static final Error DOWNLOAD_BLOCKED = new Error("DOWNLOAD_BLOCKED");
    public static final Error CONCURRENT_STREAMS_LIMIT_REACHED = new Error("CONCURRENT_STREAMS_LIMIT_REACHED");
    public static final Error NOT_AVAILABLE_IN_FORMAT = new Error("NOT_AVAILABLE_IN_FORMAT");
    public static final Error FORBIDDEN = new Error("FORBIDDEN");
    public static final Error CONNECTION_REFUSED = new Error("CONNECTION_REFUSED");
    public static final Error UNKNOWN_ERROR = new Error("UNKNOWN_ERROR");

    final String mMessage;

    Error(String message) {
        mMessage = message;
    }

    public static Error fromJson(JSONObject errorJSON) throws JSONException {
        return new Error(errorJSON.getString("message"));
    }

    public String toString() {
        return mMessage;
    }

    public String toString(Context context) {
        int nameResourceID = context.getResources().getIdentifier(mMessage, "string", context.getApplicationInfo().packageName);
        if (0 == nameResourceID) {
            return mMessage;
        }else {
            return context.getString(nameResourceID);
        }
    }
}
