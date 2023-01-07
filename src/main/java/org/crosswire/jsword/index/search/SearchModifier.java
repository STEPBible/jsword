package org.crosswire.jsword.index.search;

import java.io.Serializable;

/**
 * A SearchModifier consists of the kinds of changes that can be done to a
 * search.
 */
public interface SearchModifier extends Serializable {
    /**
     * @return true if the results of the search request should be ranked
     */
    boolean isRanked();

    /**
     * @return the maximum number of results, with Integer.MAX_VALUE meaning
     *         all.
     */
    int getMaxResults();
}
