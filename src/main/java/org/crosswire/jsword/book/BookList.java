package org.crosswire.jsword.book;

import java.util.List;

/**
 * There are several lists of Books, the most important being the installed
 * Books, however there may be others like the available books or books from a
 * specific driver. This interface provides a common method of accessing all of
 * them.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @see gnu.lgpl.License
 * @author Joe Walker [joe at eireneh dot com]
 */
public interface BookList {
    /**
     * Get a list of all the Books of all types.
     */
    List<Book> getBooks();

    /**
     * Get a filtered list of all the Books.
     * 
     * @see BookFilters
     */
    List<Book> getBooks(BookFilter filter);

    /**
     * Remove a BibleListener from our list of listeners
     * 
     * @param li
     *            The old listener
     */
    void addBooksListener(BooksListener li);

    /**
     * Add a BibleListener to our list of listeners
     * 
     * @param li
     *            The new listener
     */
    void removeBooksListener(BooksListener li);
}
