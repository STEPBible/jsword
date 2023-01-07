package org.crosswire.jsword.index.query;

import org.crosswire.jsword.book.BookException;
import org.crosswire.jsword.index.Index;
import org.crosswire.jsword.passage.Key;

/**
 * The search.Searcher uses a Query to calculate a search result.
 */
public interface Query {
    /**
     * Find the keys that match the query in the index
     * 
     * @param index
     *            the index to search
     * @return the set of keys that match
     * @throws BookException
     */
    Key find(Index index) throws BookException;
}
