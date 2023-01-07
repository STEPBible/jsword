package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the img element.
 */
public class ImgTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "img";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element img = OSISUtil.factory().createFigure();
        img.setAttribute(OSISUtil.ATTRIBUTE_FIGURE_SRC, attrs.getValue("src"));

        if (ele != null) {
            ele.addContent(img);
        }

        return img;
    }
}
