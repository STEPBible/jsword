package org.crosswire.jsword.index.query;

/**
 * A QueryDecorator allows for the decoration of strings in a way that is
 * appropriate for a Query.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith [ dmsmith555 at yahoo dot com]
 */
public interface QueryDecorator {
    String decoratePhrase(String queryWords);

    String decorateAllWords(String queryWords);

    String decorateAnyWords(String queryWords);

    String decorateNotWords(String queryWords);

    String decorateStartWords(String queryWords);

    String decorateSpellWords(String queryWords);

    String decorateRange(String queryWords);
}
