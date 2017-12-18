package net.ericsson.emovs.utilities;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import net.ericsson.emovs.utilities.models.EmpAsset;
import net.ericsson.emovs.utilities.models.EmpImage;
import net.ericsson.emovs.utilities.system.CheckRoot;
import net.ericsson.emovs.utilities.system.DeviceInfo;
import net.ericsson.emovs.utilities.system.FileSerializer;
import net.ericsson.emovs.utilities.system.OneTimeRunnable;
import net.ericsson.emovs.utilities.system.RunnableThread;
import net.ericsson.emovs.utilities.system.ServiceUtils;
import net.ericsson.emovs.utilities.system.StorageMetrics;
import net.ericsson.emovs.utilities.time.DateTimeParser;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.io.File;
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
public class SystemTest {
    @Test
    public void testCheckRoot() throws Exception {
        boolean isRooted = CheckRoot.isDeviceRooted();
        assertFalse(isRooted);
    }

    @Test
    public void testFileSerializer() throws Exception {
        String fpath = File.createTempFile("android_", "test").getAbsolutePath();
        FileSerializer.write("DummyTest", fpath);
        String ser = FileSerializer.read(fpath);
        assertEquals("DummyTest", ser);
    }

    @Test
    public void testFileSerializerJson() throws Exception {
        String fpath = File.createTempFile("android_", "test").getAbsolutePath();

        EmpImage serializerTest = new EmpImage();
        serializerTest.url = "https://test.com";

        FileSerializer.writeJson(serializerTest, fpath);
        EmpImage ser = FileSerializer.readJson(new EmpImage(), fpath);
        assertEquals("https://test.com", ser.url);
    }

    @Test
    public void testStorageMetrics() throws Exception {
        assertFalse(StorageMetrics.externalMemoryAvailable());

        String b =  StorageMetrics.formatSize(2);
        String kb = StorageMetrics.formatSize(1025);
        String mb = StorageMetrics.formatSize((1024*1024) + 1);

        assertTrue(b.contains(" B"));
        assertTrue(kb.contains(" KB"));
        assertTrue(mb.contains(" MB"));

        assertTrue(StorageMetrics.getTotalExternalMemorySize() == -1);
    }

    @Test
    public void testServiceUtils() throws Exception {
        Activity activity = Robolectric.setupActivity(Activity.class);
        Context appContext = activity.getApplicationContext();
        boolean b = ServiceUtils.isServiceRunning(appContext, Object.class);
        assertFalse(b);
    }

    @Test
    public void testDeviceInfo() throws Exception {
        Activity activity = Robolectric.setupActivity(Activity.class);
        Context appContext = activity.getApplicationContext();
        try {
            DeviceInfo info = DeviceInfo.collect(appContext);
            assertEquals("Android", info.os);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOneTimeRunnable() throws Exception {
        Runer runer = new Runer ();
        OneTimeRunnable one = new OneTimeRunnable(runer);
        one.run();
        assertTrue(runer.counter == 1);
        one.run();
        assertTrue(runer.counter == 1);
    }

    @Test
    public void testRunnableThread() throws Exception {
        Runer runer = new Runer ();
        RunnableThread thd = new RunnableThread(runer);
        thd.start();
        thd.join();
        assertTrue(runer.counter == 1);
    }

    class Runer implements Runnable {
        public int counter = 0;

        @Override
        public void run() {
            counter++;
        }
    };
}