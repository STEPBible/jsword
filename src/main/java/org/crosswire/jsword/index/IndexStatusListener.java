package org.crosswire.jsword.index;

import java.util.EventListener;

/**
 * IndexStatusListeners are able to be notified about changes to the IndexStatus
 * of a book.
 */
public interface IndexStatusListener extends EventListener {
    /**
     * Called whenever the IndexStatus of a book has changed.
     * 
     * @param ev
     *            A description of the change
     */
    void statusChanged(IndexStatusEvent ev);
}
