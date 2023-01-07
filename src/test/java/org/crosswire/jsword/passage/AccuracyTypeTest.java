package org.crosswire.jsword.passage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.crosswire.jsword.JSMsg;
import org.crosswire.jsword.versification.Versification;
import org.crosswire.jsword.versification.system.Versifications;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test
 */
public class AccuracyTypeTest {

    private Versification rs;

    @Before
    public void setUp() throws Exception {
        // AV11N(DMS): Update test to test all V11Ns
        rs = Versifications.instance().getDefaultVersification();
    }

    @Test
    public void testFromText_onePartInvalidBook() {
        try {
            AccuracyType.fromText(rs, "10", new String[] { "10"}, null, null);
        } catch (NoSuchVerseException nsve) {
            // expected
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            fail("ArrayIndexOutOfBoundsException caught, expecting NoSuchVerseException");
        }

    }

    @Test
    public void testFromText_TooManyParts() {
        boolean caught = false;
        try {
            AccuracyType.fromText(rs, "1:2:3:4", new String[] { "1", "2", "3", "4"}, null, null);
        } catch (NoSuchVerseException nsve) {
            // TRANSLATOR: The user specified a verse with too many separators. {0} is a placeholder for the allowable separators.
            NoSuchVerseException correctException = new NoSuchVerseException(JSMsg.gettext("Too many parts to the Verse. (Parts are separated by any of {0})", 
                "1:2:3:4, 1, 2, 3, 4"));
            assertEquals("Unexpected exception message", correctException.getMessage(), nsve.getMessage());
            caught = true;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            fail("ArrayIndexOutOfBoundsException caught, expecting NoSuchVerseException");
        }

        if (!caught) {
            fail("Expected fromText to throw an exception when passed too many parts");
        }
    }

    @Test
    public void testFromText_ThreePartsInvalidBook() {
        boolean caught = false;
        try {
            AccuracyType.fromText(rs, "-1:2:3", new String[] { "-1", "2", "3"}, null, null);
        } catch (NoSuchVerseException nsve) {
            // TRANSLATOR: The user specified a verse with too many separators. {0} is a placeholder for the allowable separators.
            NoSuchVerseException correctException = new NoSuchVerseException(JSMsg.gettext("Too many parts to the Verse. (Parts are separated by any of {0})", 
                    "-1:2:3, -1, 2, 3"));
            assertEquals("Unexpected exception message", correctException.getMessage(), nsve.getMessage());
            caught = true;
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            fail("ArrayIndexOutOfBoundsException caught, expecting NoSuchVerseException");
        }

        if (!caught) {
            fail("Expected fromText to throw an exception when passed three parts with an invalid book");
        }
    }

}
