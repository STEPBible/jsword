package org.crosswire.jsword.index;

import java.util.EventObject;

/**
 * An IndexStatusEvent is fired whenever the IndexStatus of a book has changed.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class IndexStatusEvent extends EventObject {
    /**
     * Basic constructor
     * 
     * @param status
     *            The new status of the book.
     */
    public IndexStatusEvent(Object source, IndexStatus status) {
        super(source);

        indexStatus = status;
    }

    /**
     * @return Returns the indexStatus.
     */
    public IndexStatus getIndexStatus() {
        return indexStatus;
    }

    /**
     * The indexStatus of the book.
     */
    private IndexStatus indexStatus;

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3834876879554819894L;

}
