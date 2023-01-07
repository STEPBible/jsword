package org.crosswire.jsword.index.lucene.analysis;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.ChineseAnalyzer;

/**
 * Uses org.apache.lucene.analysis.cn.ChineseAnalyzer Analysis:
 * ChineseTokenizer, ChineseFilter StopFilter, Stemming not implemented yet
 * 
 * Note: org.apache.lucene.analysis.cn.CJKAnalyzer takes overlapping two
 * character tokenization approach which leads to larger index size.
 */
public class ChineseLuceneAnalyzer extends AbstractBookAnalyzer {
    public ChineseLuceneAnalyzer() {
        myAnalyzer = new ChineseAnalyzer();
    }

    /* (non-Javadoc)
     * @see org.apache.lucene.analysis.Analyzer#tokenStream(java.lang.String, java.io.Reader)
     */
    @Override
    public final TokenStream tokenStream(String fieldName, Reader reader) {
        return myAnalyzer.tokenStream(fieldName, reader);
    }

    /* (non-Javadoc)
     * @see org.apache.lucene.analysis.Analyzer#reusableTokenStream(java.lang.String, java.io.Reader)
     */
    @Override
    public final TokenStream reusableTokenStream(String fieldName, Reader reader) throws IOException {
        return myAnalyzer.reusableTokenStream(fieldName, reader);
    }

    private ChineseAnalyzer myAnalyzer;
}
