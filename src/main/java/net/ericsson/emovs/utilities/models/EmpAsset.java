package net.ericsson.emovs.utilities.models;


import net.ericsson.emovs.utilities.interfaces.IPlayable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Joao Coelho on 15/07/2017.
 */
public class EmpAsset extends IPlayable {
    public String assetId;
    public String originalTitle;
    private String jsonObj;

    public Long lastViewedOffset;
    public Long lastViewedTime;
    public Long durationMillis;
    public LocalizedMetadata localized;

    public EmpAsset() {
        localized = new LocalizedMetadata();
    }

    public String getId() {
        return assetId;
    }

    @Override
    public JSONObject getJson() {
        try {
            if (this.jsonObj == null) {
                return new JSONObject().put("assetId", assetId);
            }
            return new JSONObject(this.jsonObj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setJson(JSONObject ob) {
        this.jsonObj = ob.toString();
    }

    public void setProps(EmpAsset other) {
        this.assetId = other.assetId;
        this.originalTitle = other.originalTitle;
        this.localized.images.clear();
        this.localized.images.putAll(other.localized.images);
        this.localized.titles.clear();
        this.localized.titles.putAll(other.localized.titles);
        this.localized.descriptions.clear();
        this.localized.descriptions.putAll(other.localized.descriptions);
        this.jsonObj = other.jsonObj;
    }


}
