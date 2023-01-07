package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the root element.
 */
public class RootTag extends AbstractTag {
    /**
     * This is added by the parser to we make the string accessible
     */
    protected static final String TAG_ROOT = "root";

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return TAG_ROOT;
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        return OSISUtil.factory().createDiv();
    }
}
