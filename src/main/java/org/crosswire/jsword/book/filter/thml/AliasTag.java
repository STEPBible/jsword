package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the bold element.
 */
public class AliasTag extends AbstractTag {
    /**
     * simple ctor
     */
    public AliasTag(String alias, Tag tag) {
        this.alias = alias;
        this.tag = tag;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return alias;
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        return tag.processTag(book, key, ele, attrs);
    }

    /**
     * The tag we are aliasing to
     */
    private Tag tag;

    /**
     * The alias that we are using for the other tag
     */
    private String alias;
}
