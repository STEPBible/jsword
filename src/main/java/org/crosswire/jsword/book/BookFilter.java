package org.crosswire.jsword.book;

/**
 * A method of filtering Books.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public interface BookFilter {
    /**
     * Does this given book pass the tests implemented by this filter
     * 
     * @param book
     *            The Book to test
     * @return boolean true if it passes, false otherwise
     */
    boolean test(Book book);
}
