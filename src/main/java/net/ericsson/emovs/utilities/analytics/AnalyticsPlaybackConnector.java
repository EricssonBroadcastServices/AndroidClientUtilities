package net.ericsson.emovs.utilities.analytics;


import net.ericsson.emovs.utilities.interfaces.IPlayer;
import net.ericsson.emovs.utilities.models.EmpProgram;

/**
 * Created by Joao Coelho on 2017-11-17.
 */

public class AnalyticsPlaybackConnector {
    protected IPlayer player;

    public AnalyticsPlaybackConnector() {

    }

    public void bindPlayer(IPlayer player) {
        this.player = player;
    }

    public void onInit() {
        // Stub!
    }

    public void onEntitlementLoadStart() {
        // Stub!
    }

    public void onEntitlementChange() {
        // Stub!
    }

    public void onLoadStart() {
        // Stub!
    }

    public void onLoad() {
        // Stub!
    }

    public void onPlay() {
        // Stub!
    }

    public void onPlaying() {
        // Stub!
    }

    public void onPause() {
        // Stub!
    }

    public void onSeek(long position) {
        // Stub!
    }

    public void onResume() {
        // Stub!
    }

    public void onWaitingStart() {
        // Stub!
    }

    public void onWaitingEnd() {
        // Stub!
    }

    public void onBitrateChange(int oldBitrate, int newBitrate) {
        // Stub!
    }

    public void onPlaybackEnd() {
        // Stub!
    }

    public void onDispose() {
        // Stub!
    }

    public void onStop() {
        // Stub!
    }

    public void onError(int errorCode, String errorMessage) {
        // Stub!
    }

    public void onProgramChange(EmpProgram newProgram) {
        // Stub!
    }
}
