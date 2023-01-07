package org.crosswire.common.config;

import java.util.Map;

/**
 * MappedChoice is simply a Choice where there are a number of alternative
 * options where each entry is a Map.Entry.
 * 
 * @param <K> the key's type
 * @param <V> the value's type
 */
public interface MappedChoice<K, V> extends Choice {
    /**
     * The available alternative values to be presented as options to the user
     * where the user interface allows presentation of alternatives.
     * @return A string array of alternatives.
     */
    Map<K, V> getOptions();
}
