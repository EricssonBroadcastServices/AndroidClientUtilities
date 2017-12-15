package com.ebs.android.utilities;

import net.ericsson.emovs.utilities.models.EmpAsset;
import net.ericsson.emovs.utilities.time.DateTimeParser;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.TimeZone;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

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
@RunWith(RobolectricTestRunner.class)
public class DateTimeParserTest {
    @Test
    public void parseUtcDateTime() throws Exception {
        Calendar calendar = new GregorianCalendar(2017, 1, 23, 12, 35, 40);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));

        assertEquals(calendar.getTime(), DateTimeParser.parseUtcDateTime("2017-02-23T12:35:40Z", false));
    }

    @Test
    public void formatUtcDateTime() throws Exception {
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        calendar.set(2017, 1, 23, 12, 35, 40);

        String timeToCompare = DateTimeParser.formatUtcDateTime(calendar.getTime());
        assertTrue(timeToCompare.startsWith("2017-02-23T12:35:40"));
        assertTrue(timeToCompare.endsWith("Z"));
    }

    @Test
    public void testMockito() throws Exception {
        JSONObject object = new JSONObject();
        object.put(",", "");

        EmpAsset mockedAsset = mock(EmpAsset.class);
        mockedAsset.assetId = "1";

        when(mockedAsset.getId()).thenReturn("2");

        assertTrue(mockedAsset.getId().equals("2"));
    }
}