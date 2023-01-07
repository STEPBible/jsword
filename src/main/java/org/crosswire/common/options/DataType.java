package org.crosswire.common.options;

import org.crosswire.common.util.Convert;

/**
 * A DataType provides the ability to marshal a String value to an object.
 */
public enum DataType {
    /**
     * A string argument.
     */
    STRING  ("String") {
        @Override
        public Object convertFromString(String value) {
            return value;
        }
    },

    /**
     * An integer argument.
     */
    INTEGER  ("Integer") {
        @Override
        public Object convertFromString(String value) {
            return Integer.valueOf(Convert.string2Int(value));
        }
    },

    /**
     * An boolean argument that allows various values for 'true'.
     */
    BOOLEAN ("Boolean") {
        @Override
        public Object convertFromString(String value) {
            return Boolean.valueOf(Convert.string2Boolean(value));
        }
    };

    /**
     * @param name
     *            The name of the DataType
     */
    private DataType(String name) {
        this.name = name;
    }

    /**
     * Convert a String to an DataType's expected value.
     * @param input the string to convert
     * @return the converted value
     */
    public abstract Object convertFromString(String input);

    /**
     * Lookup method to convert from a String
     */
    public static DataType fromString(String name) {
        for (DataType v : values()) {
            if (v.name().equalsIgnoreCase(name)) {
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
