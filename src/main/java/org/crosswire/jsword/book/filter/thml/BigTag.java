package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the big element.
 */
public class BigTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "big";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element hiEle = OSISUtil.factory().createHI();
        hiEle.setAttribute(OSISUtil.OSIS_ATTR_TYPE, OSISUtil.HI_X_BIG);
        if (ele != null) {
            ele.addContent(hiEle);
        }

        return hiEle;
    }
}
