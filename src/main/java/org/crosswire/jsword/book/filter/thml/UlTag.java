package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the ul element.
 */
public class UlTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "ul";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element list = OSISUtil.factory().createList();
        list.setAttribute(OSISUtil.OSIS_ATTR_TYPE, OSISUtil.LIST_UNORDERED);

        if (ele != null) {
            ele.addContent(list);
        }

        return list;
    }
}
