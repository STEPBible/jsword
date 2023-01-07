package org.crosswire.common.config;

/**
 * MultipleChoice is simply a Choice where there are a number of alternative
 * options.
 */
public interface MultipleChoice extends Choice {
    /**
     * The available alternative values to be presented as options to the user
     * where the user interface allows presentation of alternatives.
     * 
     * @return A string array of alternatives.
     */
    String[] getOptions();
}
