package net.ericsson.emovs.utilities.interfaces;

import net.ericsson.emovs.utilities.errors.ErrorRunnable;
import net.ericsson.emovs.utilities.models.EmpProgram;
import net.ericsson.emovs.utilities.queries.EpgQueryParameters;

import java.util.ArrayList;

/**
 * Created by Joao Coelho on 2018-02-12.
 */

public interface IMetadataProvider {
    void getEpgWithTime(String channelId, long nowMs, IMetadataCallback<ArrayList<EmpProgram>> iMetadataCallback, EpgQueryParameters epgParams);
    void getProgramDetails(String channelId, String programId, IMetadataCallback<EmpProgram> iMetadataCallback);
}
