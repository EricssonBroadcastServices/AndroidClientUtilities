package net.ericsson.emovs.utilities.interfaces;


/**
 * Created by Joao Coelho on 2017-11-21.
 */

public interface IPlayer {
    void release();
    void pause();
    void resume();
    void stop();
    void seekTo(long positionMs);
    long getCurrentTime();
    long getDuration();
    boolean isAutoPlay();
    boolean isPlaying();
    int getCurrentBitrate();
    String getTechVersion();
    String getTechIdentifier();
    String getIdentifier();
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

    String[] getTextTracks();

    /**
     *
     *
     * @param language language code to select the audio track (e.g.: en, pt, es, fr)
     */
    void selectAudioTrack(String language);

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
}
