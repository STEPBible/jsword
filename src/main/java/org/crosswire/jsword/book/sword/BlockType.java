package org.crosswire.jsword.book.sword;

import org.crosswire.jsword.JSOtherMsg;


/**
 * Block types indicates the grain of compression.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public enum BlockType {
    /**
     * The level of compression is the Book
     */
    BLOCK_BOOK ("BOOK", 'b'),

    /**
     * The level of compression is the Book
     */
    BLOCK_CHAPTER ("CHAPTER", 'c'),

    /**
     * The level of compression is the Book
     */
    BLOCK_VERSE ("VERSE", 'v');

    /**
     * Simple ctor
     */
    private BlockType(String name, char indicator) {
        this.name = name;
        this.indicator = indicator;
    }

    /**
     * Return a character indicating the grain of compression. This is used in
     * the names of compressed sword books.
     * 
     * @return the indicator
     */
    public char getIndicator() {
        return indicator;
    }

    /**
     * Lookup method to convert from a String
     */
    public static BlockType fromString(String name) {
        for (BlockType v : values()) {
            if (v.name.equalsIgnoreCase(name)) {
                return v;
            }
        }

        throw new ClassCastException(JSOtherMsg.lookupText("DataType {0} is not defined!", name));
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * The name of the BlockType
     */
    private String name;
    /**
     * The indicator for the BlockType
     */
    private char indicator;
}
