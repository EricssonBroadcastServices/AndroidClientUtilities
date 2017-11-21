package net.ericsson.emovs.utilities.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Joao Coelho on 15/07/2017.
 */

public class EmpSeries implements Serializable {
    public String seriesId;
    public ArrayList<EmpEpisode> episodes;
    public LocalizedMetadata localized;

    public EmpSeries() {
        this.localized = new LocalizedMetadata();
    }
}
