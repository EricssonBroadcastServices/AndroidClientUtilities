package net.ericsson.emovs.utilities.entitlements;

/**
 * Created by Joao Coelho on 2017-11-20.
 */

public interface IEntitlementProvider {

    boolean isEntitled(String mediaId);

    void playVod(final String assetId, final IEntitlementCallback listener);

    void playCatchup(final String channelId, final String programId, final IEntitlementCallback listener);

    void playLive(final String channelId, final IEntitlementCallback listener);
}
