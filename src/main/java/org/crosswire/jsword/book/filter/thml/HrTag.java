package org.crosswire.jsword.book.filter.thml;

/**
 * THML Tag to process the hr element.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public class HrTag extends AbstractTag {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "hr";
    }
}
