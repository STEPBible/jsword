package org.crosswire.jsword.index.lucene.analysis;

import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.el.GreekAnalyzer;
import org.apache.lucene.analysis.el.GreekLowerCaseFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.Reader;

/**
 * Analyzer that removes the accents from the Hebrew text
 */
public class HebrewLuceneAnalyzer extends AbstractBookAnalyzer {
    public HebrewLuceneAnalyzer() {

    }

    @Override
    public TokenStream tokenStream(String fieldName, Reader reader) {
        TokenStream result = new StandardTokenizer(matchVersion, reader);
        result = new HebrewPointingFilter(result);

        return result;
    }


    @Override
    public TokenStream reusableTokenStream(String fieldName, Reader reader) throws IOException {
        SavedStreams streams = (SavedStreams) getPreviousTokenStream();
        if (streams == null) {
            streams = new SavedStreams(new StandardTokenizer(matchVersion, reader));
            streams.setResult(new HebrewPointingFilter(streams.getResult()));

            setPreviousTokenStream(streams);
        } else {
            streams.getSource().reset(reader);
        }
        return streams.getResult();
    }

    private final Version matchVersion = Version.LUCENE_29;
}
