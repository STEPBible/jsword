package org.crosswire.jsword.index.search;

import org.crosswire.jsword.index.query.QueryDecorator;
import org.crosswire.jsword.index.query.QueryDecoratorFactory;

/**
 * An Enumeration of the possible types of Searches.
 */
public enum SearchType {
    /**
     * Find the words in the specified order.
     */
    PHRASE ("Phrase") {
        @Override
        public String decorate(String queryWords) {
            return SEARCH_SYNTAX.decoratePhrase(queryWords);
        }
    },

    /**
     * Find all the words regardless of position.
     */
    ALL_WORDS ("All") {
        @Override
        public String decorate(String queryWords) {
            return SEARCH_SYNTAX.decorateAllWords(queryWords);
        }
   },

    /**
     * Find any of these words
     */
    ANY_WORDS ("Any") {
        @Override
        public String decorate(String queryWords) {
            return SEARCH_SYNTAX.decorateAnyWords(queryWords);
        }
    },

    /**
     * Find verses not containing these words. Note this may require being added
     * after words being sought.
     */
    NOT_WORDS ("Not") {
        @Override
        public String decorate(String queryWords) {
            return SEARCH_SYNTAX.decorateNotWords(queryWords);
        }
    },

    /**
     * Find verses with words that start with the these beginnings.
     */
    START_WORDS ("Start") {
        @Override
        public String decorate(String queryWords) {
            return SEARCH_SYNTAX.decorateStartWords(queryWords);
        }
    },

    /**
     * Find verses with words spelled something like
     */
    SPELL_WORDS ("Spell") {
        @Override
        public String decorate(String queryWords) {
            return SEARCH_SYNTAX.decorateSpellWords(queryWords);
        }
    },

    /**
     * Find verses in this range
     */
    RANGE ("Range") {
        @Override
        public String decorate(String queryWords) {
            return SEARCH_SYNTAX.decorateRange(queryWords);
        }
    };

    /**
     * @param name
     *            The name of the BookCategory
     */
    private SearchType(String name) {
        this.name = name;
    }

    /**
     * Decorate a string with the given type of decoration.
     */
    public abstract String decorate(String queryWords);

    /**
     * Lookup method to convert from a String
     */
    public static SearchType fromString(String name) {
        for (SearchType v : values()) {
            if (v.name.equalsIgnoreCase(name)) {
                return v;
            }
        }

        throw new ClassCastException("Not a valid search type");
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * The name of the BookCategory
     */
    private String name;

    protected static final QueryDecorator SEARCH_SYNTAX = QueryDecoratorFactory.getSearchSyntax();
}
