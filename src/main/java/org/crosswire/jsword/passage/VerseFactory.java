package org.crosswire.jsword.passage;

import org.crosswire.jsword.versification.Versification;

/**
 * A factory to create a Verse from user input.
 */
public final class VerseFactory {
    /**
     * Prevent a VerseFactory from being created.
     */
    private VerseFactory() {
    }

    /**
     * Construct a Verse from a String - something like "Gen 1:1". in case the
     * user does not want to have their typing 'fixed' by a meddling patronizing
     * computer. The following initial letters can not be matched at all -
     * 'bfquvwx'.
     * 
     * @param original
     *            The text string to be converted
     * @return the Verse representation of the string
     * @exception NoSuchVerseException
     *                If the text can not be understood
     */
    public static Verse fromString(Versification v11n, String original) throws NoSuchVerseException {
        if ("".equals(original)) {
            return null;
        }
        String[] parts = AccuracyType.tokenize(original);
        AccuracyType accuracy = AccuracyType.fromText(v11n, original, parts);
        assert accuracy != null;
        return accuracy.createStartVerse(v11n, null, parts);
    }

    /**
     * Construct a Verse from a String and a VerseRange. For example given "2:2"
     * and a basis of Gen 1:1 - 12 the result would be Gen 2:2
     * 
     * @param original
     *            The string describing the verse e.g "2:2"
     * @param verseRangeBasis
     *            The basis by which to understand the desc.
     * @return the verse representation of the string
     * @exception NoSuchVerseException
     *                If the reference is illegal
     */
    public static Verse fromString(Versification v11n, String original, VerseRange verseRangeBasis) throws NoSuchVerseException {
        if ("".equals(original)) {
            return null;
        }
        String[] parts = AccuracyType.tokenize(original);
        AccuracyType accuracy = AccuracyType.fromText(v11n, original, parts, null, verseRangeBasis);
        assert accuracy != null;
        return accuracy.createStartVerse(v11n, verseRangeBasis, parts);
    }

}
