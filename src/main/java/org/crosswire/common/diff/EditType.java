package org.crosswire.common.diff;

/**
 * An Enumeration of the possible Edits.
 */
public enum EditType  {
    /**
     * Delete a sequence.
     */
    DELETE  ("Delete", '-'),

    /**
     * Insert a sequence
     */
    INSERT  ("Insert", '+'),

    /**
     * Equal sequences
     */
    EQUAL ("Equal", ' ');

    /**
     * @param name
     *            The name of the FeatureType
     */
    private EditType(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * @return te symbol for this EditType
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Get a CompressorType from a String
     * 
     * @param name the case insensitive representation of the desired CompressorType
     * @return the desired compressor or null if not found.
     */
    public static EditType fromString(String name) {
        for (EditType v : values()) {
            if (v.name().equalsIgnoreCase(name)) {
                return v;
            }
        }

        // cannot get here
        assert false;
        return null;
    }

    /**
     * Lookup method to convert from a String
     */
    public static EditType fromSymbol(char symbol) {
        for (EditType v : values()) {
            if (v.symbol == symbol) {
                return v;
            }
        }

        // cannot get here
        assert false;
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * The name of the FeatureType
     */
    private String name;

    /**
     * The symbol representing the EditType
     */
    private char symbol;
}
