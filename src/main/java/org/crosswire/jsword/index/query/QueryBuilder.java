package org.crosswire.jsword.index.query;

/**
 * A QueryBuilder builds a Query from a String.
 */
public interface QueryBuilder {
    /**
     * Construct a query from a string.
     * 
     * @param aQuery
     *            The text to convert
     * @return a query.
     */
    Query parse(String aQuery);
}
