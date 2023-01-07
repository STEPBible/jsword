package org.crosswire.jsword.book;

/**
 * A method of filtering Books.
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
