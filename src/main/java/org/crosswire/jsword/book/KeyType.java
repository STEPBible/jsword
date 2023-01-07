package org.crosswire.jsword.book;


/**
 * Types of Key that a Book uses, either verse, list, or tree.
 */
public enum KeyType {
    /**
     * Book contains verses and can be understood as book, chapter and verse.
     */
    VERSE,

    /**
     * Book organizes its entries in a list, as in a dictionary.
     */
    LIST,

    /**
     * Book organizes its entries in a tree, as in a general book.
     */
    TREE;

    /**
     * Get an integer representation for this CaseType
     */
    public int toInteger() {
        return ordinal();
    }

    /**
     * Lookup method to convert from a String
     */
    public static KeyType fromString(String name) {
        for (KeyType v : values()) {
            if (v.name().equalsIgnoreCase(name)) {
                return v;
            }
        }

        // cannot get here
        assert false;
        return null;
    }

}
