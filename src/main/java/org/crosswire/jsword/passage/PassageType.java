package org.crosswire.jsword.passage;

import org.crosswire.jsword.versification.Versification;

/**
 * Types of Passage optimizations.
 */
public enum PassageType {
    /**
     * Optimize the Passage for speed
     */
    SPEED {
        @Override
        public Passage createPassage(Versification v11n, String passage, Key basis) throws NoSuchVerseException {
            if (passage == null || passage.length() == 0) {
                return createEmptyPassage(v11n);
            }
            return new RocketPassage(v11n, passage, basis);
        }

        @Override
        public Passage createEmptyPassage(Versification v11n) {
            return new RocketPassage(v11n);
        }
    },

    /**
     * Optimize the Passage for write speed
     */
    WRITE_SPEED {
        @Override
        public Passage createPassage(Versification v11n, String passage, Key basis) throws NoSuchVerseException {
            if (passage == null || passage.length() == 0) {
                return createEmptyPassage(v11n);
            }
            return new BitwisePassage(v11n, passage, basis);
        }

        @Override
        public Passage createEmptyPassage(Versification v11n) {
            return new BitwisePassage(v11n);
        }
    },

    /**
     * Optimize the Passage for size
     */
    SIZE {
        @Override
        public Passage createPassage(Versification v11n, String passage, Key basis) throws NoSuchVerseException {
            if (passage == null || passage.length() == 0) {
                return createEmptyPassage(v11n);
            }
            return new DistinctPassage(v11n, passage, basis);
        }

        @Override
        public Passage createEmptyPassage(Versification v11n) {
            return new DistinctPassage(v11n);
        }

        /**
         * Serialization ID
         */
        private static final long serialVersionUID = -1959355535575121168L;
    },

    /**
     * Optimize the Passage for a mix
     */
    MIX {
        @Override
        public Passage createPassage(Versification v11n, String passage, Key basis) throws NoSuchVerseException {
            if (passage == null || passage.length() == 0) {
                return createEmptyPassage(v11n);
            }
            return new RangedPassage(v11n, passage, basis);
        }

        @Override
        public Passage createEmptyPassage(Versification v11n) {
            return new RangedPassage(v11n);
        }
    },

    /**
     * Optimize the Passage for tally operations
     */
    TALLY {
        @Override
        public Passage createPassage(Versification v11n, String passage, Key basis) throws NoSuchVerseException {
            if (passage == null || passage.length() == 0) {
                return createEmptyPassage(v11n);
            }
            return new PassageTally(v11n, passage, basis);
        }

        @Override
        public Passage createEmptyPassage(Versification v11n) {
            return new PassageTally(v11n);
        }
    };

    /**
     * Create an optimized passage
     * 
     * @param passage
     * @return the optimized passage
     * @throws NoSuchVerseException
     */
    public abstract Passage createPassage(Versification v11n, String passage, Key basis) throws NoSuchVerseException;
    public Passage createPassage(Versification v11n, String passage) throws NoSuchVerseException {
        return createPassage(v11n, passage, null);
    }

    /**
     * Create an empty, optimized passage
     * 
     * @return the optimized, empty passage
     * @throws NoSuchVerseException
     */
    public abstract Passage createEmptyPassage(Versification v11n);

    /**
     * Lookup method to convert from a String
     */
    public static PassageType fromString(String name) {
        for (PassageType v : values()) {
            if (v.name().equalsIgnoreCase(name)) {
                return v;
            }
        }

        // cannot get here
        assert false;
        return null;
    }

    /**
     * Lookup method to convert from an integer
     */
    public static PassageType fromInteger(int i) {
        for (PassageType v : values()) {
            if (v.ordinal() == i) {
                return v;
            }
        }

        // on error return SPEED
        return SPEED;
    }

    /**
     * Lookup method to convert from an integer
     */
    public static int toInteger(PassageType type) {
        return type.ordinal();
    }
}
