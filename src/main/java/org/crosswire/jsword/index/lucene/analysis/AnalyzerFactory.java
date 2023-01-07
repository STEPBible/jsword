package org.crosswire.jsword.index.lucene.analysis;

import java.io.IOException;

import org.crosswire.common.util.ClassUtil;
import org.crosswire.common.util.Language;
import org.crosswire.common.util.PropertyMap;
import org.crosswire.common.util.ResourceUtil;
import org.crosswire.jsword.book.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A factory creating the appropriate Analyzer for natural language analysis of
 * text for Lucene Indexing and Query Parsing. Note: [Lang] refers to CommonName
 * for ISO639 Language Dependency: Analyzer from lucene contrib:
 * lucene-analyzers-[version].jar, lucene-smartcn-[version].jar,
 * lucene-snowball-[version].jar
 * 
 * Properties used: <Key> : <Value> Default.Analyzer : The default analyzer
 * class [Lang].Analyzer : Appropriate Analyzer class to be used for the
 * language of the book
 */
public final class AnalyzerFactory {
    public AbstractBookAnalyzer createAnalyzer(Book book) {
        AbstractBookAnalyzer newObject = null;
        Language lang = book == null ? null : book.getLanguage();
        if (lang != null) {
            String aClass = getAnalyzerValue(lang);

            log.debug("Creating analyzer:{} BookLang:{}", aClass, lang);

            if (aClass != null) {
                try {
                    Class<AbstractBookAnalyzer> impl = (Class<AbstractBookAnalyzer>) ClassUtil.forName(aClass);

                    newObject = impl.newInstance();
                } catch (ClassNotFoundException e) {
                    log.error("Configuration error in AnalyzerFactory properties", e);
                } catch (IllegalAccessException e) {
                    log.error("Configuration error in AnalyzerFactory properties", e);
                } catch (InstantiationException e) {
                    log.error("Configuration error in AnalyzerFactory properties", e);
                }
            }
        }

        if (newObject == null) {
            newObject = new SimpleLuceneAnalyzer();
        }

        // Configure the analyzer
        newObject.setBook(book);
        newObject.setDoStemming(getDefaultStemmingProperty());
        newObject.setDoStopWords(getDefaultStopWordProperty());
        return newObject;
    }

    public static AnalyzerFactory getInstance() {
        return myInstance;
    }

    private AnalyzerFactory() {
        loadProperties();
    }

    public String getAnalyzerValue(Language lang) {
        String key = lang.getCode() + ".Analyzer";
        return myProperties.get(key);
    }

    public boolean getDefaultStemmingProperty() {
        String key = DEFAULT_ID + ".Stemming";
        return Boolean.valueOf(myProperties.get(key)).booleanValue();
    }

    public boolean getDefaultStopWordProperty() {
        String key = DEFAULT_ID + ".StopWord";
        return Boolean.valueOf(myProperties.get(key)).booleanValue();
    }

    private void loadProperties() {
        try {
            myProperties = ResourceUtil.getProperties(getClass());
        } catch (IOException e) {
            log.error("AnalyzerFactory property load from file failed", e);
        }
    }

    public static final String DEFAULT_ID = "Default";
    private static AnalyzerFactory myInstance = new AnalyzerFactory();

    private PropertyMap myProperties;

    /**
     * The log stream
     */
    private static final Logger log = LoggerFactory.getLogger(AnalyzerFactory.class);
}
