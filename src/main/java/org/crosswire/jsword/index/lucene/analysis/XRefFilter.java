package org.crosswire.jsword.index.lucene.analysis;

import java.io.IOException;

import org.apache.lucene.analysis.TokenStream;
import org.crosswire.jsword.book.Book;

/**
 * A KeyFilter normalizes OSISrefs.
 */
public class XRefFilter extends AbstractBookTokenFilter {
    /**
     * Construct filtering <i>in</i>.
     */
    public XRefFilter(TokenStream in) {
        this(null, in);
    }

    /**
     * Construct an XRefFilter tied to a Book.
     * 
     * @param book
     *            the book to which this TokenFilter is tied.
     * @param in
     *            the input TokenStream
     */
    public XRefFilter(Book book, TokenStream in) {
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
