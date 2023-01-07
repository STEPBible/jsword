package org.crosswire.jsword.passage;

/**
 * Types of Passage Lists.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 * @author DM Smith
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
