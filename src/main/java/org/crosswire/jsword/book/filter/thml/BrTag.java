package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the new line element.
 */
public class BrTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "br";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element lb = OSISUtil.factory().createLB();

        if (ele != null) {
            ele.addContent(lb);
        }

        return lb;
    }
}
