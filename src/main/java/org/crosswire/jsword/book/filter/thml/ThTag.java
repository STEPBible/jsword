package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the th element.
 */
public class ThTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "th";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element cell = OSISUtil.factory().createCell();

        if (ele != null) {
            ele.addContent(cell);
        }

        Element hi = OSISUtil.factory().createHI();
        hi.setAttribute(OSISUtil.OSIS_ATTR_TYPE, OSISUtil.HI_BOLD);
        cell.addContent(hi);
        return hi;
    }
}
