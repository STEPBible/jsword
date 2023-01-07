package org.crosswire.common.util;

/**
 * A method of filtering objects to those that match an arbitrary criteria.
 * 
 * @param <T> The type of the object subject to testing.
 */
public interface Filter<T> {
    /**
     * Does this given object pass the test implemented by this filter
     * 
     * @param obj
     *            The object to test
     * @return boolean true if it passes, false otherwise
     */
    boolean test(T obj);
}
