package org.crosswire.jsword.index;


/**
 * An Enumeration of the possible states of an index.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public enum IndexStatus {
    /**
     * There is a complete and ready to use search index
     */
    DONE("Indexed"),

    /**
     * There is no search index, and no plans to create one
     */
    UNDONE("No Index"),

    /**
     * This Book has been scheduled for index creation
     */
    SCHEDULED("Scheduled"),

    /**
     * An index is currently being generated for this Book
     */
    CREATING("Creating"),

    /**
     * An index is no longer valid and needs to be discarded.
     */
    INVALID("Invalid");

    /**
     * @param name
     *            The name of the BookCategory
     */
    private IndexStatus(String name) {
        this.name = name;
    }

    /**
     * Lookup method to convert from a String
     */
    public static IndexStatus fromString(String name) {
        for (IndexStatus o : IndexStatus.values()) {
            if (o.name.equalsIgnoreCase(name)) {
                return o;
            }
        }
        // cannot get here
        assert false;
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * The name of the IndexStatus
     */
    private String name;

}
