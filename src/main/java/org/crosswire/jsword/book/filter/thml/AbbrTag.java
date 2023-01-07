package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the abbr element.
 */
public class AbbrTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "abbr";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element seg = OSISUtil.factory().createAbbr();

        if (ele != null) {
            ele.addContent(seg);
        }

        return seg;
    }
}
