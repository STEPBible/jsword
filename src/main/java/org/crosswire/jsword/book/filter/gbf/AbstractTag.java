package org.crosswire.jsword.book.filter.gbf;

/**
 * A Tag that has a tagname from the input.
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
