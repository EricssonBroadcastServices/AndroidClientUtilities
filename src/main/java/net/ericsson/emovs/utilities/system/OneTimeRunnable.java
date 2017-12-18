package net.ericsson.emovs.utilities.system;

/**
 * Created by Joao Coelho on 2017-12-08.
 */

public class OneTimeRunnable implements Runnable {
    boolean invalidated = false;
    Runnable runnable;

    public OneTimeRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public synchronized void run() {
        if(invalidated) {
            return;
        }
        invalidated = true;
        if (this.runnable != null) {
            this.runnable.run();
        }
    }
}
