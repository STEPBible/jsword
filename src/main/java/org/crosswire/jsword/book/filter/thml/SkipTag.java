package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;

/**
 * Skip the tag and it's content.
 */
public class SkipTag extends AnonymousTag {
    /**
     * Simple ctor
     */
    public SkipTag(String name) {
        super(name);
    }

    @Override
    public void processContent(Book book, Key key, Element ele) {
        // Remove this element and all it's children
        Element parent = ele.getParentElement();
        parent.removeContent(ele);
    }
}
