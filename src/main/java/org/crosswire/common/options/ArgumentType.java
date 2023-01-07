package org.crosswire.common.options;

/**
 * An ArgumentType indicates whether and/or how an Option is followed by an
 * argument.
 */
public enum ArgumentType {
    /**
     * The option is not followed by an argument.
     */
    NO_ARGUMENT  ("NO"),

    /**
     * The option is followed by an argument.
     */
    REQUIRED_ARGUMENT  ("Required"),

    /**
     * The option may be followed by an argument.
     */
    OPTIONAL_ARGUMENT ("Optional");

    /**
     * @param name
     *            The name of the DataType
     */
    private ArgumentType(String name) {
        this.name = name;
    }

    /**
     * Lookup method to convert from a String
     */
    public static ArgumentType fromString(String name) {
        for (ArgumentType v : values()) {
            if (v.name.equalsIgnoreCase(name)) {
                return v;
            }
        }

        // cannot get here
        assert false;
        return null;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * The name of the DataType
     */
    private String name;
}
