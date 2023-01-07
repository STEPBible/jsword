package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the citation element.
 */
public class CitationTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "citation";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element q = OSISUtil.factory().createQ();
        q.setAttribute(OSISUtil.OSIS_ATTR_TYPE, OSISUtil.Q_BLOCK);

        if (ele != null) {
            ele.addContent(q);
        }

        return q;
    }
}
