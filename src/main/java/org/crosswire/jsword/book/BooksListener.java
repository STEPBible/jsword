package org.crosswire.jsword.book;

import java.util.EventListener;

/**
 * BiblesListeners are able to be notified about changes to the numbers of
 * Bibles installed on the system.
 */
public interface BooksListener extends EventListener {
    /**
     * Called whenever a new Bible is added to the system.
     * 
     * @param ev
     *            A description of the change
     */
    void bookAdded(BooksEvent ev);

    /**
     * Called whenever a Bible is removed from the system.
     * 
     * @param ev
     *            A description of the change
     */
    void bookRemoved(BooksEvent ev);
}
