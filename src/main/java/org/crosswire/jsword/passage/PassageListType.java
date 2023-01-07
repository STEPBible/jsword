package org.crosswire.jsword.passage;

/**
 * Types of Passage Lists.
 */
public enum PassageListType {
    /**
     * Passage to be interpreted as a list of verses.
     */
    VERSES {
        @Override
        public Object getElementAt(Passage ref, int index, RestrictionType restrict) {
            if (ref == null) {
                return null;
            }
            return ref.getVerseAt(index);
        }

        @Override
        public int count(Passage ref, RestrictionType restrict) {
            if (ref == null) {
                return 0;
            }
            return ref.countVerses();
        }
    },

    /**
     * Passage to be interpreted as a list of ranges.
     */
    RANGES {
        @Override
        public Object getElementAt(Passage ref, int index, RestrictionType restrict) {
            if (ref == null) {
                return null;
            }
            return ref.getRangeAt(index, restrict);
        }

        @Override
        public int count(Passage ref, RestrictionType restrict) {
            if (ref == null) {
                return 0;
            }
            return ref.countRanges(restrict);
        }
    };

    public abstract Object getElementAt(Passage ref, int index, RestrictionType restrict);

    public abstract int count(Passage ref, RestrictionType restrict);
}
