package org.crosswire.jsword.index.query;

/**
 * A BinaryQuery consists of a Left and a Right Query
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith
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
