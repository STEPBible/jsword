package org.crosswire.jsword.index.lucene.analysis;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.KeywordTokenizer;
import org.apache.lucene.analysis.TokenStream;
import org.crosswire.jsword.book.Book;

/**
 * A specialized analyzer that normalizes Strong's Numbers.
 */
public class KeyAnalyzer extends AbstractBookAnalyzer {
    /**
     * Construct a default KeyAnalyzer.
     */
    public KeyAnalyzer() {
    }

    /**
     * Construct an KeyAnalyzer tied to a book.
     */
    public KeyAnalyzer(Book book) {
        setBook(book);
    }

    /* (non-Javadoc)
     * @see org.apache.lucene.analysis.Analyzer#tokenStream(java.lang.String, java.io.Reader)
     */
    @Override
    public TokenStream tokenStream(String fieldName, Reader reader) {
        return new KeyFilter(getBook(), new KeywordTokenizer(reader));
    }

    /* (non-Javadoc)
     * @see org.apache.lucene.analysis.Analyzer#reusableTokenStream(java.lang.String, java.io.Reader)
     */
    @Override
    public TokenStream reusableTokenStream(String fieldName, Reader reader) throws IOException {
        SavedStreams streams = (SavedStreams) getPreviousTokenStream();
        if (streams == null) {
            streams = new SavedStreams(new KeywordTokenizer(reader));
            streams.setResult(new KeyFilter(getBook(), streams.getResult()));
            setPreviousTokenStream(streams);
        } else {
            streams.getSource().reset(reader);
        }
        return streams.getResult();
    }

}
