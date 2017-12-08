package net.ericsson.emovs.utilities.models;


import net.ericsson.emovs.utilities.interfaces.IPlayable;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Joao Coelho on 15/07/2017.
 */

public class EmpChannel extends IPlayable {
    public String channelId;
    public String originalTitle;
    public ArrayList<EmpProgram> programs;
    public LocalizedMetadata localized;

    public EmpChannel(){
        this.localized = new LocalizedMetadata();
    }

    @Override
    public LocalizedMetadata getLocalized() {
        return localized;
    }

    public EmpProgram liveProgram() {
        if(programs == null || programs.size() == 0) {
            return null;
        }
        for(int i = 0; i < this.programs.size(); ++i) {
            if (programs.get(i).liveNow()) {
                return programs.get(i);
            }
        }
        return null;
    }

    public int liveProgramIndex() {
        if(programs == null || programs.size() == 0) {
            return 0;
        }
        for(int i = 0; i < this.programs.size(); ++i) {
            if (programs.get(i).liveNow()) {
                return i;
            }
        }
        return 0;
    }

    public String getId() {
        return "live@" + channelId;
    }

    @Override
    public JSONObject getJson() {
        // TODO: implement
        return null;
    }
}
