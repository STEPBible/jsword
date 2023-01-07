package org.crosswire.jsword.passage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * JUnit Test.
 */
public class PassageConstantsTest {

    @Test
    public void testAllowedDelims() {
        // Check that we're not re-using delimiters
        for (int i = 0; i < AccuracyType.VERSE_ALLOWED_DELIMS.length(); i++) {
            assertEquals(-1, AbstractPassage.REF_ALLOWED_DELIMS.indexOf(AccuracyType.VERSE_ALLOWED_DELIMS.charAt(i)));
            assertNotEquals(VerseRange.RANGE_OSIS_DELIM, AccuracyType.VERSE_ALLOWED_DELIMS.charAt(i));
        }

        for (int i = 0; i < AbstractPassage.REF_ALLOWED_DELIMS.length(); i++) {
            assertNotEquals(VerseRange.RANGE_OSIS_DELIM, AbstractPassage.REF_ALLOWED_DELIMS.charAt(i));
        }
    }
}
