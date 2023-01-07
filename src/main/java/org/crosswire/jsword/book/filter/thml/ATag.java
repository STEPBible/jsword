package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the a (Reference) element.
 */
public class ATag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "a";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element reference = OSISUtil.factory().createReference();

        String href = attrs.getValue("href");
        if (href != null && href.length() > 0) {
            reference.setAttribute(OSISUtil.OSIS_ATTR_REF, href);
        }

        if (ele != null) {
            ele.addContent(reference);
        }

        return reference;
    }
}
