package org.crosswire.jsword.book.filter;

import java.util.List;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Content;

/**
 * A generic interface for things that can convert a String into OSIS data.
 */
public interface Filter extends Cloneable {
    /**
     * Converter from plain (encoded) text to OSIS data
     * 
     * @param key
     *            The key for the text
     * @param plain
     *            The encoded text
     * @return a List of OSIS Elements
     */
    List<Content> toOSIS(Book book, Key key, String plain);

    /**
     * This needs to be declared here so that it is visible as a method on a
     * derived Filter.
     * 
     * @return A complete copy of ourselves
     */
    Filter clone();
}
