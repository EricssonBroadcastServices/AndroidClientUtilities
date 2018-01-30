package net.ericsson.emovs.utilities.interfaces;


import net.ericsson.emovs.utilities.entitlements.Entitlement;
import net.ericsson.emovs.utilities.models.EmpProgram;


/**
 * Created by Joao Coelho on 2017-11-21.
 */

public interface IEntitledPlayer extends IPlayer {
    /**
     * Returns Entitlement for current playback.
     * This object has important playback-related information, for example: manifest locator, contract restrictions, bookmark values, etc..
     */
    Entitlement getEntitlement();

    /**
     * Returns current playable
     */
    IPlayable getPlayable();

    /**
     * Returns current playback session ID
     */
    String getSessionId();

    /**
     * Returns current program being played:
     * - Differs from getPlayable because getPlayable returns the playable loaded by user
     * - For instance when a program boundary is crossed, then a new program is issued
     */
    EmpProgram getCurrentProgram();
}
