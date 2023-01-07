package org.crosswire.jsword.book;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.EventObject;

/**
 * A BooksEvent is fired whenever a Bible is added or removed from the system.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public class BooksEvent extends EventObject {
    /**
     * Basic constructor
     * 
     * @param book
     *            The book of the changed Bible, or null if there is more than
     *            one change.
     * @param added
     *            True if the changed Bible is an addition.
     */
    public BooksEvent(Object source, Book book, boolean added) {
        super(source);

        this.book = book;
        this.added = added;
    }

    /**
     * Get the name of the changed Book
     * 
     * @return The Book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Is this an addition event?
     */
    public boolean isAddition() {
        return added;
    }

    /**
     * Serialization support.
     * 
     * @param is
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        // Broken but we don't serialize events
        book = null;
        is.defaultReadObject();
    }

    /**
     * Is this an addition event?
     */
    private boolean added;

    /**
     * The name of the changed Bible
     */
    private transient Book book;

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3834876879554819894L;
}
