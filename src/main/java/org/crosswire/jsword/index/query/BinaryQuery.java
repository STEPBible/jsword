package org.crosswire.jsword.index.query;

/**
 * A BinaryQuery consists of a Left and a Right Query
 */
public interface BinaryQuery extends Query {

    /**
     * @return Returns the leftQuery.
     */
    Query getLeftQuery();

    /**
     * @return Returns the rightQuery.
     */
    Query getRightQuery();

}
