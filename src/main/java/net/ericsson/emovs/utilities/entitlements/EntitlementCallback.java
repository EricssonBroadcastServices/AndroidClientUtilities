package net.ericsson.emovs.utilities.entitlements;

import android.util.Log;

import net.ericsson.emovs.utilities.errors.Error;
import net.ericsson.emovs.utilities.errors.ErrorCodes;
import net.ericsson.emovs.utilities.errors.ErrorRunnable;
import net.ericsson.emovs.utilities.system.RunnableThread;

/**
 * Created by Joao Coelho on 2017-09-26.
 */

public class EntitlementCallback implements IEntitlementCallback {
    String assetId;
    String channelId;
    String programId;
    EntitledRunnable runnable;
    ErrorRunnable errorRunnable;

    public EntitlementCallback(String assetId, String channelId, String programId, EntitledRunnable runnable, ErrorRunnable errorRunnable) {
        this.assetId = assetId;
        this.channelId = channelId;
        this.programId = programId;
        this.runnable = runnable;
        this.errorRunnable = errorRunnable;
    }

    @Override
    public void onEntitlement(final Entitlement entitlement, String requestId) {
        this.runnable.entitlement = entitlement;
        this.runnable.requestId = requestId;
        new RunnableThread(this.runnable).start();
    }

    @Override
    public void onError(Error error) {
        Log.e("EXO PLAYER ERROR", error.toString());
        if (errorRunnable != null) {
            errorRunnable.run(ErrorCodes.EXPOSURE_ENTITLEMENT_ERROR, error.toString());
        }
    }

    @Override
    public String getAssetId() {
        return this.assetId;
    }

    @Override
    public String getChannelId() {
        return this.channelId;
    }

    @Override
    public String getProgramId() {
        return this.programId;
    }
}
