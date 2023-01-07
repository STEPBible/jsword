package org.crosswire.jsword.passage;

import java.util.EventListener;

/**
 * A PassageListener gets told when the verses in a Passage have changed (added
 * or removed).
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public interface PassageListener extends EventListener {
    /**
     * Sent after stuff has been added to the Passage, more info about what and
     * where can be had from the Event
     * 
     * @param ev
     *            a PassageEvent encapsulating the event information
     */
    void versesAdded(PassageEvent ev);

    /**
     * Sent after stuff has been removed from the Passage, more info about what
     * and where can be had from the Event
     * 
     * @param ev
     *            a PassageEvent encapsulating the event information
     */
    void versesRemoved(PassageEvent ev);

    /**
     * Sent after verses have been simultaneously added and removed from the
     * Passage, more info about what and where can be had from the Event
     * 
     * @param ev
     *            a PassageEvent encapsulating the event information
     */
    void versesChanged(PassageEvent ev);
}
