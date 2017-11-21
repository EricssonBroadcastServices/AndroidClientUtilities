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
}
