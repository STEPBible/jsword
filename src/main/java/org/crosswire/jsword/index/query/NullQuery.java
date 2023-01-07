package org.crosswire.jsword.index.query;

import org.crosswire.jsword.book.BookException;
import org.crosswire.jsword.index.Index;
import org.crosswire.jsword.passage.Key;

/**
 * A null query searches for nothing and returns an empty Key.
 */
public class NullQuery implements Query {
    /**
     * Create a NullQuery.
     */
    public NullQuery() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.index.query.Query#find(org.crosswire.jsword.index
     * .search.Index)
     */
    public Key find(Index index) throws BookException {
        return index.find(null);
    }

}
