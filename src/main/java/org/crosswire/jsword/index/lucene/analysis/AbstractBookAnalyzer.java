package org.crosswire.jsword.index.lucene.analysis;

import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.crosswire.jsword.book.Book;

/**
 * Base class for Analyzers. Note: All analyzers configured in
 * AnalyzerFactory.properties should be of this type
 */
public abstract class AbstractBookAnalyzer extends Analyzer {

    public AbstractBookAnalyzer() {
        this(null);
    }

    public AbstractBookAnalyzer(Book book) {
        this.book = book;
        doStopWords = false;
        doStemming = true;
    }

    /**
     * The book for which analysis is being performed.
     * 
     * @param newBook
     */
    public void setBook(Book newBook) {
        book = newBook;
    }

    /**
     * @return the book for which analysis is being performed.
     */
    public Book getBook() {
        return book;
    }

    public void setDoStopWords(boolean doIt) {
        doStopWords = doIt;
    }

    public boolean getDoStopWords() {
        return doStopWords;
    }

    public void setStopWords(Set<?> stopWords) {
        stopSet = stopWords;
    }


    public void setDoStemming(boolean stemming) {
        doStemming = stemming;
    }

    /**
     * The book against which analysis is performed.
     */
    protected Book book;

    protected Set<?> stopSet;

    // for turning on/off stop word removal during analysis
    protected boolean doStopWords;

    // for turning on/off stemming
    protected boolean doStemming;
}
