package org.crosswire.jsword.book.filter.thml;

/**
 * THML Tag to process the pb (page break) element. Do nothing since pages are a
 * hard copy kind of thing.
 */
public class PbTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "pb";
    }

}
