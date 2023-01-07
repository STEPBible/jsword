package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;

/**
 * Process the content of an element but to ignore the tag itself.
 */
public class IgnoreTag extends AnonymousTag {
    /**
     * Simple ctor
     */
    public IgnoreTag(String name) {
        super(name);
    }

    @Override
    public void processContent(Book book, Key key, Element ele) {
        // Replace the parent with this element
        Element parent = ele.getParentElement();
        parent.removeContent(ele);
        parent.addContent(ele.removeContent());
    }
}
