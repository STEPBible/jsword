package org.crosswire.jsword.index.lucene.analysis;

import java.io.IOException;

import org.apache.lucene.analysis.TokenStream;
import org.crosswire.jsword.book.Book;

/**
 * A KeyFilter normalizes Key.
 */
public class KeyFilter extends AbstractBookTokenFilter {
    /**
     * Construct a KeyFilter not tied to a Book.
     * 
     * @param in
     *            the input TokenStream
     */
    public KeyFilter(TokenStream in) {
        this(null, in);
    }

    /**
     * Construct a KeyFilter tied to a Book.
     * 
     * @param book
     *            the book to which this TokenFilter is tied.
     * @param in
     *            the input TokenStream
     */
    public KeyFilter(Book book, TokenStream in) {
        super(book, in);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.lucene.analysis.TokenStream#incrementToken()
     */
    @Override
    public boolean incrementToken() throws IOException {
        // TODO(DMS): actually normalize
        return input.incrementToken();
    }
}
