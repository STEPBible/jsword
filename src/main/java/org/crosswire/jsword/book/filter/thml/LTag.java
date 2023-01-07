package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the l line element.
 */
public class LTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "li";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element item = OSISUtil.factory().createL();

        if (ele != null) {
            ele.addContent(item);
        }

        return item;
    }
}
