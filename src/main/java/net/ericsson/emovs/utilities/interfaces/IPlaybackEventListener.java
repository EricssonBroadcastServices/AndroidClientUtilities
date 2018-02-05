package net.ericsson.emovs.utilities.interfaces;

import net.ericsson.emovs.utilities.models.EmpProgram;

/**
 * Interface to a event listener that the player is able to work with
 *
 * Created by Joao Coelho on 2017-09-27.
 */
public interface IPlaybackEventListener {
    enum EventId {
        PROGRAM_CHANGED,
        WARNING
    };
    /**
     * Fired when player is initiated
     */
    void onInit();

    /**
     * Fired when the entitlement is requested to the backend
     */
    void onEntitlementLoadStart();

    /**
     * Fired when the entitlement has arrived from backend
      */
    void onEntitlementChange();

    /**
     * Fired when player starts loading the media segments
     */
    void onLoadStart();

    /**
     * Fired when the player has loaded all the segments necessary to start playback
     */
    void onLoad();

    /**
     * Fired when the player receives a command to start playback
     */
    void onPlay();

    /**
     * Fired when the playback actually starts playback
     */
    void onPlaying();
//    void onAudioTrackChange();
//    void onTextTrackChange();

    /**
     * Fired when the playback is paused
     */
    void onPause();

    /**
     * Fired when the player has seeked the media
     * @param position
     */
    void onSeek(long position);

    /**
     * Fired when the playback is resumed after a paused state
     */
    void onResume();

    /**
     * Fired when the playback is temporarily interrupted (buffering, loss of decoding resources, etc..)
     */
    void onWaitingStart();

    /**
     * Fired when the playback resumes from a waiting state
     *
     */
    void onWaitingEnd();

    /**
     * Fired when the player changes the bitrate of the displyed stream
     *
     * @param oldBitrate
     * @param newBitrate
     */
    void onBitrateChange(int oldBitrate, int newBitrate);
//    void onProgramChange();
//    void onCastingStart();
//    void onCastingStop();

    /**
     * Fired when the playback is ended
     */
    void onPlaybackEnd();

    /**
     * Fired when the player is disposed
     */
    void onDispose();

    /**
     * Fired when the playback is stopped
     */
    void onStop();

    /**
     * Fired when an error occurs - by definition, an error is any event worthy of interest that causes the playback to stop without user's direct or indirect intervention
     *
     * @param errorCode
     * @param errorMessage
     */
    void onError(int errorCode, String errorMessage);

    /**
     * Fired when a warning occurs - by definition, a warning is any event worthy of interest that does not cause the playback to stop
     *
     * @param warningCode
     * @param warningMessage
     */
    void onWarning(int warningCode, String warningMessage);

    /**
     * Fired when controller visibility changes (hidden or visible)
     *
     * @param visibility
     */
    void onControllerVisibility(ControllerVisibility visibility);

    /**
     * Fired when current playback crosses a program boundary and starts playing a new program
     *
     * @param newProgram
     */
    void onProgramChange(EmpProgram newProgram);
}
