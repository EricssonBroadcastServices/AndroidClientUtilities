package com.ebs.android.utilities;

import net.ericsson.emovs.utilities.DateTimeParser;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

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
public class DateTimeParserTest {
    @Test
    public void parseUtcDateTime() throws Exception {
        Calendar calendar = new GregorianCalendar(2017, 1, 23, 12, 35, 40);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        assertEquals(calendar.getTime(), DateTimeParser.parseUtcDateTime("2017-02-23T12:35:40.00Z", true));
    }

    @Test
    public void formatUtcDateTime() throws Exception {
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        calendar.set(2017, 1, 23, 12, 35, 40);

        String timeToCompare = DateTimeParser.formatUtcDateTime(calendar.getTime());
        assertTrue(timeToCompare.startsWith("2017-02-23T12:35:40."));
        assertTrue(timeToCompare.endsWith("Z"));
    }

}