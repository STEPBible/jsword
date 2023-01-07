package org.crosswire.jsword.index.search;

import org.crosswire.jsword.book.BookException;
import org.crosswire.jsword.index.Index;
import org.crosswire.jsword.index.query.Query;
import org.crosswire.jsword.passage.Key;

/**
 * The central interface to all searching.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public interface Searcher {
    /**
     * Setup the index that this parser can use to do word level searches
     * 
     * @param index
     *            The Index to query for words
     */
    void init(Index index);

    /**
     * Take a search request and decipher it into a Passage.
     * 
     * @param request
     *            The request
     * @return The matching verses
     */
    Key search(SearchRequest request) throws BookException;

    /**
     * Take a search request and decipher it into a Passage.
     * 
     * @param request
     *            The request
     * @return The matching verses
     */
    Key search(Query request) throws BookException;
}
