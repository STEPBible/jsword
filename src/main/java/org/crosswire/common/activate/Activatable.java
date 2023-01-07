package org.crosswire.common.activate;

/**
 * A class can be Activatable if it needs a significant amount of memory on an
 * irregular basis, and so would benefit from being told when to wake-up and
 * when to conserver memory.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public interface Activatable {
    /**
     * Called to indicate that the Book should initialize itself, and consume
     * whatever system resources it needs to be able to respond to other
     * queries.
     * 
     * @param lock
     *            An attempt to ensure that only the Activator calls this method
     */
    void activate(Lock lock);

    /**
     * Called to indicate that the Book should release whatever system resources
     * it can to make way for other uses.
     * 
     * @param lock
     *            An attempt to ensure that only the Activator calls this method
     */
    void deactivate(Lock lock);
}
