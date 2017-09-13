package com.ebs.android.utilities;
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

/**
 * ISO 8601 date/time conversion utility
 *
 * @author Olivier Braun
 */
public class DateTimeParser {
    private static final TimeZone utc = TimeZone.getTimeZone("UTC");
    private static final DateFormat iso8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    /**
     * Converts an <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a>
     * string to {@link java.util.Date}
     *
     * @param datetime ISO 8601 formatted String
     * @return parsed {@link java.util.Date}
     * @throws ParseException if datetime is not a valid ISO 8601 string
     */
    public static Date parseUtcDateTime(String datetime) throws ParseException {
        iso8601.setTimeZone(utc);
        return iso8601.parse(datetime);
    }

    /**
     * Converts a {@link java.util.Date} object to an <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a> string
     *
     * @param datetime
     * @return ISO 8601 string
     */
    public static String formatUtcDateTime(Date datetime) {
        iso8601.setTimeZone(utc);
        return iso8601.format(datetime);
    }
}
