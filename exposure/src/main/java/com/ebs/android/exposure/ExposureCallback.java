package com.ebs.android.exposure;
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

import org.json.JSONObject;

/**
 * Exposure response event
 */
public interface ExposureCallback {
    /**
     * Delegate for Exposure response callback handling
     *
     * @param response Exposure response, null if there is an error
     * @param error Exposure error, null if there is none
     */
    void onCallCompleted(JSONObject response, JSONObject error);
}
