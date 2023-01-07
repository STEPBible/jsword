package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * The AbstractTag ignores the tag.
 */
public abstract class AbstractTag implements Tag {

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#processTag(org.crosswire.jsword.book.Book, org.jdom2.Element, org.xml.sax.Attributes)
     */
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        // Ignore the tag
        return null;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#processContent(org.crosswire.jsword.book.Book, org.jdom2.Element)
     */
    public void processContent(Book book, Key key, Element ele) {
        // By default do nothing
    }

}
