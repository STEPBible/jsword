package org.crosswire.jsword.index.lucene.analysis;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.crosswire.jsword.book.Book;

/**
 * An AbstractBookTokenFilter ties a Lucene TokenFilter to a Book.
 */
public abstract class AbstractBookTokenFilter extends TokenFilter {

    /**
     * Create a TokenFilter not tied to a Book.
     * 
     * @param input
     *            the token stream to filter
     */
    public AbstractBookTokenFilter(TokenStream input) {
        this(null, input);
    }

    /**
     * Create a TokenFilter tied to a Book.
     * 
     * @param input
     *            the token stream to filter
     */
    public AbstractBookTokenFilter(Book book, TokenStream input) {
        super(input);
        this.book = book;
    }

    /**
     * @return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * @param book
     *            the book to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /* Define to quite FindBugs */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* Define to quite FindBugs */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private Book book;
}
