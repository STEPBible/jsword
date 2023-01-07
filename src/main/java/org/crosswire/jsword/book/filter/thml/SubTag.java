package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the subscript element.
 */
public class SubTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "sub";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element hi = OSISUtil.factory().createHI();
        hi.setAttribute(OSISUtil.OSIS_ATTR_TYPE, OSISUtil.HI_SUB);

        if (ele != null) {
            ele.addContent(hi);
        }

        return hi;
    }
}
