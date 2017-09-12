package com.ebs.android.clientutilities;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeParser {
    private static final TimeZone utc = TimeZone.getTimeZone("UTC");
    private static final DateFormat iso8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static Date parseUtcDateTime(String datetime) throws ParseException {
        iso8601.setTimeZone(utc);
        return iso8601.parse(datetime);
    }

    public static String formatUtcDateTime(Date datetime) {
        iso8601.setTimeZone(utc);
        return iso8601.format(datetime);
    }
}
