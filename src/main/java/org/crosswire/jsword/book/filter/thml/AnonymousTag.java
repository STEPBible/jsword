package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process an element that does not map to OSIS.
 */
public class AnonymousTag extends AbstractTag {
    public AnonymousTag(String name) {
        tagName = name;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return tagName;
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element seg = OSISUtil.factory().createSeg();
        seg.setAttribute(OSISUtil.OSIS_ATTR_TYPE, OSISUtil.TYPE_X_PREFIX + getTagName());

        if (ele != null) {
            ele.addContent(seg);
        }

        return seg;
    }

    /**
     * The alias that we are using for the other tag
     */
    private String tagName;
}
