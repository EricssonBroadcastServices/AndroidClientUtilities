package net.ericsson.emovs.utilities.errors;

/**
 * Created by Joao Coelho on 2017-09-28.
 */

public interface ErrorRunnable {
    void run(int errorCode, String errorMessage);
}
