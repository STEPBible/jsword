package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the foreign element.
 */
public class ForeignTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "foreign";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element div = OSISUtil.factory().createForeign();

        String lang = attrs.getValue("lang");
        if (lang != null) {
            // OSIS defines the long attribute as the one from the xml namespace
            div.setAttribute(OSISUtil.OSIS_ATTR_LANG, lang, Namespace.XML_NAMESPACE);
        }

        if (ele != null) {
            ele.addContent(div);
        }

        return div;
    }
}
