package org.crosswire.common.diff;

/**
 * Represents the location of the best match.
 */
public interface Locator {
    /**
     * Locate the best match of a pattern in text near a supplied location.
     * 
     * @return Best match index or -1, if no match found
     */
    int locate();

    /**
     * The maximum length a pattern can be.
     * 
     * @return maximum pattern length.
     */
    int maxPatternLength();
}
