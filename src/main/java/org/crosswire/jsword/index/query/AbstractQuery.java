package org.crosswire.jsword.index.query;

/**
 * A base query is the smallest unit of search that the index can perform.
 */
public abstract class AbstractQuery implements Query {

    /**
     * Construct a query from a string.
     * 
     * @param theQuery
     */
    public AbstractQuery(String theQuery) {
        query = theQuery;
    }

    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    private String query;
}
