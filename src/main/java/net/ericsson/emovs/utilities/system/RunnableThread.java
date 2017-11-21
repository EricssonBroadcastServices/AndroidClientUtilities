package net.ericsson.emovs.utilities.system;

/**
 * Created by Joao Coelho on 2017-09-26.
 */

public class RunnableThread extends Thread {
    Runnable runnable;

    public RunnableThread(Runnable runnable) {
        this.runnable = runnable;
    }

    public void run() {
        if (this.runnable != null) {
            this.runnable.run();
        }
    }
}
