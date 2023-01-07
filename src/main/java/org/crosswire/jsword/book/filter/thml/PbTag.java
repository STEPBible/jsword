package org.crosswire.jsword.book.filter.thml;

/**
 * THML Tag to process the pb (page break) element. Do nothing since pages are a
 * hard copy kind of thing.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class PbTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "pb";
    }

}
