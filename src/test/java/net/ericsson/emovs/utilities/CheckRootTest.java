package net.ericsson.emovs.utilities;

import net.ericsson.emovs.utilities.models.EmpAsset;
import net.ericsson.emovs.utilities.system.CheckRoot;
import net.ericsson.emovs.utilities.time.DateTimeParser;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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
public class CheckRootTest {
    @Test
    public void testCheckRoot() throws Exception {
        boolean isRooted = CheckRoot.isDeviceRooted();
        assertFalse(isRooted);
    }
}