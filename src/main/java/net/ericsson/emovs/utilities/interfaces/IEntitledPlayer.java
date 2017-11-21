package net.ericsson.emovs.utilities.interfaces;


import net.ericsson.emovs.utilities.entitlements.Entitlement;



/**
 * Created by Joao Coelho on 2017-11-21.
 */

public interface IEntitledPlayer extends IPlayer {
    Entitlement getEntitlement();
    IPlayable getPlayable();
    String getSessionId();
}
