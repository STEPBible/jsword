package org.crosswire.jsword.book.filter.gbf;

import java.util.LinkedList;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Content;

/**
 * GBF Tag interface.
 */
public interface Tag {
    /**
     * Sub-classes should implement this method to generate OSIS Object
     */
    void updateOsisStack(Book book, Key key, LinkedList<Content> osisStack);
}
