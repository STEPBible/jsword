package org.crosswire.jsword.index.search;

import java.io.Serializable;

/**
 * A SearchRequest consists of a string and modifiers for the search.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith
 */
public interface SearchRequest extends Serializable {
    /**
     * @return the modifications to this SearchRequest
     */
    SearchModifier getSearchModifier();

    /**
     * @return the request that is being operated upon
     */
    String getRequest();
}
