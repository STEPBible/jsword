package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the div element.
 */
public class DivTag extends AbstractTag {
    /**
     * Create an div tag
     */
    public DivTag() {
        super();
        this.level = 0;
    }

    /**
     * Create an div tag of the given level
     * 
     * @param level
     */
    public DivTag(int level) {
        super();
        this.level = level;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        if (level == 0) {
            return "div";
        }
        return "div" + level;
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        // See if there are variant readings e.g. WHNU Mat 1.9
        String typeAttr = attrs.getValue("type");
        if ("variant".equals(typeAttr)) {
            Element seg = OSISUtil.factory().createSeg();
            seg.setAttribute(OSISUtil.OSIS_ATTR_TYPE, OSISUtil.VARIANT_TYPE);
            String classAttr = attrs.getValue("class");
            if (classAttr != null) {
                seg.setAttribute(OSISUtil.OSIS_ATTR_SUBTYPE, OSISUtil.VARIANT_CLASS + '-' + classAttr);
            }

            if (ele != null) {
                ele.addContent(seg);
            }

            return seg;
        }

        Element div = OSISUtil.factory().createDiv();

        if (ele != null) {
            ele.addContent(div);
        }

        return div;
    }

    /**
     * The level of the division
     */
    private int level;
}
