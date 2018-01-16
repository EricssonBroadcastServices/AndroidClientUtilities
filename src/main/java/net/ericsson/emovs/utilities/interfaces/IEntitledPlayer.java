package net.ericsson.emovs.utilities.interfaces;


import net.ericsson.emovs.utilities.entitlements.Entitlement;
import net.ericsson.emovs.utilities.models.EmpProgram;


/**
 * Created by Joao Coelho on 2017-11-21.
 */

public interface IEntitledPlayer extends IPlayer {
    Entitlement getEntitlement();
    IPlayable getPlayable();
    String getSessionId();
    EmpProgram getCurrentProgram();
}
