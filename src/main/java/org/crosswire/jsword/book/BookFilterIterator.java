package org.crosswire.jsword.book;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator that filters as it goes.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 * @author DM Smith
 */
public class BookFilterIterator implements Iterable<Book>, Iterator<Book> {
    /**
     * Simple ctor
     * 
     * @param filter
     *            The filter to use, if null, will iterate over all values
     */
    public BookFilterIterator(Iterable<Book> books, BookFilter filter) {
        this.it = books.iterator();
        this.filter = filter;
    }

    /* (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<Book> iterator() {
        return this;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    public boolean hasNext() {
        next = findNext();
        return next != null;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#next()
     */
    public Book next() {
        if (next == null) {
            throw new NoSuchElementException();
        }
        return next;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#remove()
     */
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * Find the next (if there is one)
     */
    private Book findNext() {
        while (it.hasNext()) {
            Book book = it.next();
            if (filter == null || filter.test(book)) {
                return book;
            }
        }

        return null;
    }

    /**
     * The stored next value
     */
    private Book next;

    private Iterator<Book> it;

    /**
     * The value filter
     */
    private BookFilter filter;

}
