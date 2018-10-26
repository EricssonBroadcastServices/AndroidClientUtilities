package net.ericsson.emovs.utilities.entitlements;

import net.ericsson.emovs.utilities.entitlements.Entitlement;

/**
 * Created by Joao Coelho on 2017-09-26.
 */


public class EntitledRunnable implements Runnable {
    public Entitlement entitlement;
    public String requestId;
    @Override
    public void run() {
        throw new RuntimeException("Stub!");
    }
}
