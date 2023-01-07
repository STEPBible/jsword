package org.crosswire.jsword.index.lucene.analysis;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.LowerCaseTokenizer;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.de.GermanAnalyzer;
import org.apache.lucene.analysis.de.GermanStemFilter;
import org.apache.lucene.util.Version;

/**
 * Based on Lucene's GermanAnalyzer
 */
public class GermanLuceneAnalyzer extends AbstractBookAnalyzer {
    public GermanLuceneAnalyzer() {
        stopSet = GermanAnalyzer.getDefaultStopSet();
    }

    /* (non-Javadoc)
     * @see org.apache.lucene.analysis.Analyzer#tokenStream(java.lang.String, java.io.Reader)
     */
    @Override
    public TokenStream tokenStream(String fieldName, Reader reader) {
        TokenStream result = new LowerCaseTokenizer(reader);

        if (doStopWords && stopSet != null) {
            result = new StopFilter(false, result, stopSet);
        }

        if (doStemming) {
            result = new GermanStemFilter(result);
        }

        return result;
    }

    /* (non-Javadoc)
     * @see org.apache.lucene.analysis.Analyzer#reusableTokenStream(java.lang.String, java.io.Reader)
     */
    @Override
    public TokenStream reusableTokenStream(String fieldName, Reader reader) throws IOException {
        SavedStreams streams = (SavedStreams) getPreviousTokenStream();
        if (streams == null) {
            streams = new SavedStreams(new LowerCaseTokenizer(reader));
            if (doStopWords && stopSet != null) {
                streams.setResult(new StopFilter(StopFilter.getEnablePositionIncrementsVersionDefault(matchVersion), streams.getResult(), stopSet));
            }

            if (doStemming) {
                streams.setResult(new GermanStemFilter(streams.getResult()));
            }

            setPreviousTokenStream(streams);
        } else {
            streams.getSource().reset(reader);
        }
        return streams.getResult();
    }

    private final Version matchVersion = Version.LUCENE_29;
}
