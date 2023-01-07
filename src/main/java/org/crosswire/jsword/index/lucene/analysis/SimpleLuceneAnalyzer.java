package org.crosswire.jsword.index.lucene.analysis;

import java.io.Reader;

import org.apache.lucene.analysis.ASCIIFoldingFilter;
import org.apache.lucene.analysis.LowerCaseTokenizer;
import org.apache.lucene.analysis.TokenStream;

/**
 * Simple Analyzer providing same function as
 * org.apache.lucene.analysis.SimpleAnalyzer This is intended to be the default
 * analyzer for natural language fields. Additionally performs: Normalize
 * Diacritics (Changes Accented characters to their unaccented equivalent) for
 * ISO 8859-1 languages
 * 
 * Note: Next Lucene release (beyond 2.2.0) will have a major performance
 * enhancement using method - public TokenStream reusableTokenStream(String
 * fieldName, Reader reader) We should use that. Ref:
 * https://issues.apache.org/jira/browse/LUCENE-969
 */
public class SimpleLuceneAnalyzer extends AbstractBookAnalyzer {

    public SimpleLuceneAnalyzer() {
        doStemming = false;
    }

    @Override
    public TokenStream tokenStream(String fieldName, Reader reader) {
        TokenStream result = new LowerCaseTokenizer(reader);
        result = new ASCIIFoldingFilter(result);
        return result;
    }
}
