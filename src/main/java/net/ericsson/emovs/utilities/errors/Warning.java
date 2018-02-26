package net.ericsson.emovs.utilities.errors;

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

public class Warning {
    public static final Warning PROGRAM_SERVICE_GAPS_IN_EPG = new Warning(WarningCodes.PROGRAM_SERVICE_GAPS_IN_EPG, "PROGRAM_SERVICE_GAPS_IN_EPG");
    public static final Warning SEEK_NOT_POSSIBLE = new Warning(WarningCodes.SEEK_NOT_ENTITLED, "SEEK_NOT_POSSIBLE");
    public static final Warning PROGRAM_SERVICE_ENTITLEMENT_CHECK_NOT_POSSIBLE = new Warning(WarningCodes.PROGRAM_SERVICE_ENTITLEMENT_CHECK_NOT_POSSIBLE, "BACKEND_UNAVAILABLE");
    public static final Warning INVALID_START_TIME = new Warning(WarningCodes.INVALID_START_TIME, "INVALID_START_TIME");
    public static final Warning SEEK_TO_UNAVAILABLE_POSITION = new Warning(WarningCodes.SEEK_TO_UNAVAILABLE_POSITION, "SEEK_TO_UNAVAILABLE_POSITION");

    final String mMessage;
    final int mCode;

    Warning(int code, String message) {
        mCode = code;
        mMessage = message;
    }

    public int getCode() {
        return mCode;
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
