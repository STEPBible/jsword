package org.crosswire.jsword.index.query;

/**
 * A QueryBuilder builds a Query from a String.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith
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
