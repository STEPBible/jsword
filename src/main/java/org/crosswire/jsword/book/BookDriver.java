package org.crosswire.jsword.book;

/**
 * The BibleDriver class allows creation of new Books.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public interface BookDriver extends BookProvider {
    /**
     * Is this name capable of creating writing data in the correct format as
     * well as reading it?
     * 
     * @return true/false to indicate ability to write data
     */
    boolean isWritable();

    /**
     * Create a new Book based on a source.
     * 
     * @param source
     *            The Book from which to copy data
     * @return The new WritableBible
     * @exception BookException
     *                If the name is not valid
     */
    Book create(Book source) throws BookException;

    /**
     * Is this book able to be deleted.
     * 
     * @param dead
     *            the book to be deleted
     * @return whether the book can be deleted.
     */
    boolean isDeletable(Book dead);

    /**
     * Delete this Book from the system. Take care with this method for obvious
     * reasons. For most implementations of Book etc, this method will throw up
     * because most will be read-only.
     * 
     * @throws BookException
     *             If the Book can't be deleted.
     */
    void delete(Book dead) throws BookException;

    /**
     * A short name for this BookDriver
     */
    String getDriverName();
}
