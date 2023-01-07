package org.crosswire.jsword.book.filter.gbf;

/**
 * A Tag that has a tagname from the input.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith [ dmsmith555 at yahoo dot com]
 */
public abstract class AbstractTag implements Tag {
    /**
     * @param name
     */
    public AbstractTag(String name) {
        this.name = name;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    private String name;
}
