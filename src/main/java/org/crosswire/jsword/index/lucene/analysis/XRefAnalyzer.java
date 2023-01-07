package org.crosswire.jsword.index.lucene.analysis;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.WhitespaceTokenizer;
import org.crosswire.jsword.book.Book;

/**
 * A specialized analyzer that normalizes Cross References.
 */
public class XRefAnalyzer extends AbstractBookAnalyzer {
    /**
     * Construct a default XRefAnalyzer.
     */
    public XRefAnalyzer() {
    }

    /**
     * Construct an XRefAnalyzer tied to a book.
     */
    public XRefAnalyzer(Book book) {
        setBook(book);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.lucene.analysis.Analyzer#tokenStream(java.lang.String,
     * java.io.Reader)
     */
    @Override
    public TokenStream tokenStream(String fieldName, Reader reader) {
        return new KeyFilter(getBook(), new WhitespaceTokenizer(reader));
    }

    /* (non-Javadoc)
     * @see org.apache.lucene.analysis.Analyzer#reusableTokenStream(java.lang.String, java.io.Reader)
     */
    @Override
    public TokenStream reusableTokenStream(String fieldName, Reader reader) throws IOException {
        SavedStreams streams = (SavedStreams) getPreviousTokenStream();
        if (streams == null) {
            streams = new SavedStreams(new WhitespaceTokenizer(reader));
            streams.setResult(new KeyFilter(getBook(), streams.getResult()));
            setPreviousTokenStream(streams);
        } else {
            streams.getSource().reset(reader);
        }
        return streams.getResult();
    }
}
