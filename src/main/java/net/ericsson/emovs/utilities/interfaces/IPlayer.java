package net.ericsson.emovs.utilities.interfaces;


import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by Joao Coelho on 2017-11-21.
 */

public interface IPlayer {
    /**
     * Releases all resource associated with playback and then releases the player
     */
    void release();

    /**
     * Pauses playback
     */
    void pause();

    /**
     * Checks if playback is paused
     */
    boolean isPaused();

    /**
     * Rerumes playback
     */
    void resume();

    /**
     * Stops playback
     */
    void stop();

    /**
     * Seeks to a specific position (0..duration)
     */
    void seekTo(long positionMs);

    /**
     * Returns current server unix time in milliseconds
     */
    long getServerTime();

    /**
     * Returns duration of the current playable
     */
    long getDuration();

    /**
     * Checks if current options enable autoplay
     */
    boolean isAutoPlay();

    /**
     * Checks if player is playing something (if PAUSED this method also returns true)
     */
    boolean isPlaying();

    /**
     * Returns current playback bitrate
     */
    int getCurrentBitrate();

    String getTechVersion();
    String getTechIdentifier();
    String getIdentifier();

    /**
     * Returns version of the player
     */
    String getVersion();

    /**
     * Mutes the audio
     */
    void mute();

    /**
     * Unmutes the audio (volume will be last heard volume [0..1]
     */
    void unmute();

    /**
     * Sets the audio volume level
     *
     * @param volume volume level [0..1]
     */
    void setVolume(float volume);

    /**
     * Returns a list of languages available to be chosen
     *
     * @return
     */
    String[] getAudioTracks();

    /**
     * Returns a list of available subtitles
     *
     * @return
     */
    String[] getTextTracks();

    /**
     * Selects audio track
     *
     * @param language language code to select the audio track (e.g.: en, pt, es, fr)
     */
    void selectAudioTrack(String language);

    /**
     *  Selects text track
     *
     * @param language language code to select the audio track (e.g.: en, pt, es, fr)
     */
    void selectTextTrack(String language);

    /**
     * Returns selected audio track
     *
     * @return selected audio language
     */
    String getSelectedAudioTrack();

    /**
     * Returns selected text track
     *
     * @return selected text language
     */
    String getSelectedTextTrack();

    /**
     * Seeks to a specific unix time (milliseconds)
     */
    void seekToTime(long unixTimeMs);

    long getPlayheadTime();

    /**
     * Returns position currently being displayed in milliseconds
     *
     */
    long getPlayheadPosition();

    /**
     * Returns seek offset range in milliseconds
     *
     */
    long[] getSeekRange();

    /**
     * Returns seekable unix time range in milliseconds
     *
     */
    long[] getSeekTimeRange();

    /**
     * Returns buffered position range in milliseconds
     *
     */
    long[] getBufferedRange();

    /**
     * Returns buffered unix time range in milliseconds
     *
     */
    long[] getBufferedTimeRange();

    /**
     * Used by external components or plugins to notify a player of an error
     *
     */
    void fail(int errorCode, String errorMessage);

    /**
     * Returns the activity bound to a player
     *
     */
    Activity getActivity();

    /**
     * Use the trigger method if you want to trigger an event from and external component or plugin
     *
     */
    void trigger(IPlaybackEventListener.EventId eventId, Object param);

    /**
     * Returns subtitles view for styling font size and colors
     *
     */
    View getSubtitlesView();

    /**
     * Returns true if user can seek forward
     *
     */
    boolean canSeekForward();

    /**
     * Returns true if user can seek backward
     *
     */
    boolean canSeekBack();

    /**
     * Returns true if user can pause
     *
     */
    boolean canPause();
}
