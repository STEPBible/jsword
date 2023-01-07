package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag interface - there should be one implementation of this class for
 * each THML tag.
 */
public interface Tag {
    /**
     * What element does this class represent. For example the Tag that
     * represents the font element would return the string "font".
     * @return the element's tag name
     */
    String getTagName();

    /**
     * Make changes to the specified OSIS element given the attributes passed in
     * the source document.
     * 
     * @param ele
     *            The OSIS element to use as a parent
     * @param attrs
     *            The source document attributes.
     * @return the element to which content is attached
     */
    Element processTag(Book book, Key key, Element ele, Attributes attrs);

    /**
     * Do additional processing of the tag after the element has been created.
     * 
     * @param ele
     *            the created element to process
     */
    void processContent(Book book, Key key, Element ele);
}
