package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the li element.
 */
public class LiTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "li";
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.AbstractTag#processTag(org.crosswire.jsword.book.Book, org.jdom2.Element, org.xml.sax.Attributes)
     */
    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element item = OSISUtil.factory().createItem();

        if (ele != null) {
            ele.addContent(item);
        }

        return item;
    }
}
