package org.crosswire.common.util;

/**
 * A TimeGate when entered will cause the gate to be closed for a specified
 * period of time.
 */
public class TimeGate {
    /**
     * Build a TimeGate that will allow entry no more often than count
     * milliseconds
     * 
     * @param count
     *            the length of time to keep the gate shut after opening it.
     */
    public TimeGate(int count) {
        closeTime = count;
    }

    /**
     * Determine whether entry through the gate is allowed. Opening the gate
     * will close it until the TimeGate's interval has passed.
     * 
     * @return true if one may enter.
     */
    public synchronized boolean open() {
        // check to see if the gate has been closed long enough.
        // If so, then open it and note the time that it was opened.
        long now = System.currentTimeMillis();
        if (now - then > closeTime) {
            then = now;
            return true;
        }

        // Otherwise the gate was opened not that long ago and
        // is still closed.
        return false;
    }

    /**
     * The interval during which the gate is closed.
     */
    private int closeTime;

    /**
     * The time in milliseconds that the gate last closed.
     */
    private long then;
}
