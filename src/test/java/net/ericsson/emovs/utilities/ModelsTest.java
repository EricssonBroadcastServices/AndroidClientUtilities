package net.ericsson.emovs.utilities;


import net.ericsson.emovs.utilities.models.EmpAsset;
import net.ericsson.emovs.utilities.models.EmpChannel;
import net.ericsson.emovs.utilities.models.EmpImage;
import net.ericsson.emovs.utilities.models.EmpProgram;
import net.ericsson.emovs.utilities.models.LocalizedMetadata;

import org.joda.time.DateTime;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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
public class ModelsTest {
    @Test
    public void testEmpAsset() throws Exception {
        LocalizedMetadata metadata = new LocalizedMetadata();
        metadata.descriptions.put("en", "Test subtitle");
        metadata.titles.put("en", "My title");

        ArrayList<EmpImage> imgs = new ArrayList<>();
        EmpImage img = new EmpImage();
        img.type = "Poster";
        img.orientation = EmpImage.Orientation.LANDSCAPE;
        imgs.add(img);
        metadata.images.put("en", imgs);

        EmpAsset asset = new EmpAsset();
        asset.assetId = "12345";
        asset.localized = metadata;
        assertEquals("12345", asset.getId());

        EmpImage imgBack = metadata.getImage("en", "Poster");
        EmpImage imgBack2 = metadata.getImage("en", "Thumbnail");
        assertTrue(imgBack == img);
        assertTrue(imgBack2 == null);
        assertTrue(asset.getLocalized().getDescriptions("en").equals("Test subtitle"));
        assertTrue(asset.getLocalized().getTitle("en").equals("My title"));
        assertTrue(asset.getLocalized().getDescriptions("pt") == null);
        assertTrue(asset.getLocalized().getTitle("pt") == null);
        assertTrue(asset.getLocalized().getImage("en", EmpImage.Orientation.LANDSCAPE) == img);
        assertTrue(asset.getLocalized().getImage("en", EmpImage.Orientation.PORTRAIT) == null);
        assertTrue(asset.getLocalized().getImage("en", EmpImage.Orientation.LANDSCAPE, "Poster") == img);
        assertTrue(asset.getLocalized().getImage("en", EmpImage.Orientation.PORTRAIT, "Poster") == null);
        assertTrue(asset.getLocalized().getImage("en", EmpImage.Orientation.LANDSCAPE, "Thumbnail") == null);

        EmpAsset asset2 = new EmpAsset();
        asset2.setProps(asset);
        assertEquals("12345", asset.getId());
        assertTrue(asset.getLocalized().getDescriptions("pt") == null);

        JSONObject json = new JSONObject();
        json.put("assetId", "12346");
        assertTrue (asset.getJson().optString("assetId").equals("12345"));
        asset.setJson(json);
        assertTrue (asset.getJson().optString("assetId").equals("12346"));
    }

    @Test
    public void testEmpProgram() throws Exception {
        EmpProgram program = new EmpProgram();
        program.channelId = "ch1";
        program.programId = "prg1";
        assertEquals("prg1@ch1", program.getId());
        program.startDateTime = DateTime.now().minusHours(1);
        program.endDateTime = DateTime.now().plusHours(1);
        assertTrue(program.liveNow());
        assertEquals("Today", program.timeHumanRefernce(EmpProgram.DateRef.END));
        program.startDateTime = DateTime.now().minusDays(1);
        assertEquals("Yesterday", program.timeHumanRefernce(EmpProgram.DateRef.START));
        program.startDateTime = DateTime.now().plusDays(1);
        assertEquals("Tomorrow", program.timeHumanRefernce(EmpProgram.DateRef.START));
        program.startDateTime = DateTime.now().plusDays(5);
        assertTrue(program.timeHumanRefernce(EmpProgram.DateRef.START).contains("/"));
        assertTrue(program.isFuture());
        program.getTime(EmpProgram.DateRef.START);
        program.startDateTime = DateTime.now().minusDays(5);
        assertTrue(program.timeHumanRefernce(EmpProgram.DateRef.START).contains("/"));
        program.getTime(EmpProgram.DateRef.END);
        program.startDateTime = null;
        assertFalse(program.liveNow());
        assertTrue(program.isFuture());
        assertEquals("N/A", program.getTime(EmpProgram.DateRef.START));
        assertEquals("N/A", program.timeHumanRefernce(EmpProgram.DateRef.START));
    }

    @Test
    public void testEmpChannel() throws Exception {
        EmpChannel channel = new EmpChannel();
        channel.channelId = "ch1";
        assertEquals("live@ch1", channel.getId());
        assertEquals(null, channel.getJson());
        assertTrue(channel.getLocalized() != null);

        EmpProgram program0 = new EmpProgram();
        program0.startDateTime = DateTime.now().minusHours(3);
        program0.endDateTime = DateTime.now().minusHours(2);

        EmpProgram program1 = new EmpProgram();
        program1.startDateTime = DateTime.now().minusHours(1);
        program1.endDateTime = DateTime.now().plusHours(1);

        channel.programs = new ArrayList<>();
        channel.programs.add(program0);
        channel.programs.add(program1);

        assertTrue(channel.liveProgram() == program1);
        assertTrue(channel.liveProgramIndex() == 1);
    }

}