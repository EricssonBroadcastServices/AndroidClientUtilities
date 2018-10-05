package net.ericsson.emovs.utilities.test;

public abstract class Waiter {
    /**
     * Waits until isReady returns true.
     * @param maxWaitTimeMillis
     * @return
     */
    public boolean waitUntilReady(long maxWaitTimeMillis) {
        long waitStartTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - waitStartTime < maxWaitTimeMillis) {
            if(!isReady()) {
                try {
                    Thread.sleep(1L); //Wait
                } catch (InterruptedException e) { //Thread sleep was interrupted
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean isReady();
}
