package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the h1, h2, h3, h4, h5, and h6 elements.
 */
public class HTag extends AbstractTag {
    /**
     * Create an H tag of the given level
     * 
     * @param level
     */
    public HTag(int level) {
        super();
        this.level = level;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "h" + level;
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element title = OSISUtil.factory().createTitle();
        title.setAttribute(OSISUtil.OSIS_ATTR_LEVEL, Integer.toString(level));

        if (ele != null) {
            ele.addContent(title);
        }

        return ele;
    }

    /**
     * The level of the title
     */
    private int level;
}
