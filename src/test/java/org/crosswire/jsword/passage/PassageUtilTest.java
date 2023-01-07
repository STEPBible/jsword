package org.crosswire.jsword.passage;

import static org.junit.Assert.assertEquals;

import org.crosswire.jsword.book.CaseType;
import org.crosswire.jsword.versification.BookName;
import org.crosswire.jsword.versification.Versification;
import org.crosswire.jsword.versification.system.Versifications;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class PassageUtilTest {
    /**
     * How we create Passages
     */
    private static PassageKeyFactory keyf = PassageKeyFactory.instance();
    /** Control the output of names */
    private CaseType storedCase;
    private boolean fullName;
    private boolean persist;
    private Versification v11n;

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Before
    public void setUp() throws Exception {
        storedCase = BookName.getDefaultCase();
        BookName.setCase(CaseType.SENTENCE);
        fullName = BookName.isFullBookName();
        BookName.setFullBookName(false);
        persist = PassageUtil.isPersistentNaming();

        // AV11N(DMS): Update test to test all V11Ns
        v11n = Versifications.instance().getDefaultVersification();
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @After
    public void tearDown() throws Exception {
        BookName.setCase(storedCase);
        BookName.setFullBookName(fullName);
        PassageUtil.setPersistentNaming(persist);
    }

    @Test
    public void testOther() {
        // Need to add:
        /*
         * log("PassageUtil.[s|g]etBlurRestriction()");
         * log("PassageUtil.isValidBlurRestriction()");
         * log("PassageUtil.getBlurRestrictions()");
         * log("PassageUtil.isValidCase()"); log("PassageUtil.getCases()");
         * log("PassageUtil.isValidAccuracy()"); Should there be getAccuracies()
         */
    }

    @Test
    public void testBinary() {
        byte[] buffer;
        int[] index;

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) -1, (byte) -1, (byte) -1, (byte) -1,
        };
        assertEquals(1, PassageKeyFactory.toBinary(buffer, 0, 0, 0));
        assertEquals(buffer[0], 0);
        assertEquals(buffer[1], -1);
        assertEquals(buffer[2], -1);
        assertEquals(buffer[3], -1);
        assertEquals(0, PassageKeyFactory.fromBinary(buffer, index, 0));
        assertEquals(1, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) -1, (byte) -1, (byte) -1, (byte) -1,
        };
        assertEquals(1, PassageKeyFactory.toBinary(buffer, 0, 0, 1));
        assertEquals(buffer[0], 0);
        assertEquals(buffer[1], -1);
        assertEquals(buffer[2], -1);
        assertEquals(buffer[3], -1);
        assertEquals(0, PassageKeyFactory.fromBinary(buffer, index, 1));
        assertEquals(1, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) -1, (byte) -1, (byte) -1, (byte) -1,
        };
        assertEquals(1, PassageKeyFactory.toBinary(buffer, 0, 0, 255));
        assertEquals(buffer[0], 0);
        assertEquals(buffer[1], -1);
        assertEquals(buffer[2], -1);
        assertEquals(buffer[3], -1);
        assertEquals(0, PassageKeyFactory.fromBinary(buffer, index, 255));
        assertEquals(1, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) -1, (byte) -1, (byte) -1, (byte) -1,
        };
        assertEquals(2, PassageKeyFactory.toBinary(buffer, 0, 0, 256));
        assertEquals(buffer[0], 0);
        assertEquals(buffer[1], 0);
        assertEquals(buffer[2], -1);
        assertEquals(buffer[3], -1);
        assertEquals(0, PassageKeyFactory.fromBinary(buffer, index, 256));
        assertEquals(2, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) -1, (byte) -1, (byte) -1, (byte) -1,
        };
        assertEquals(2, PassageKeyFactory.toBinary(buffer, 0, 0, 65535));
        assertEquals(buffer[0], 0);
        assertEquals(buffer[1], 0);
        assertEquals(buffer[2], -1);
        assertEquals(buffer[3], -1);
        assertEquals(0, PassageKeyFactory.fromBinary(buffer, index, 65535));
        assertEquals(2, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) -1, (byte) -1, (byte) -1, (byte) -1,
        };
        assertEquals(3, PassageKeyFactory.toBinary(buffer, 0, 0, 65536));
        assertEquals(buffer[0], 0);
        assertEquals(buffer[1], 0);
        assertEquals(buffer[2], 0);
        assertEquals(buffer[3], -1);
        assertEquals(0, PassageKeyFactory.fromBinary(buffer, index, 65536));
        assertEquals(3, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) -1, (byte) -1, (byte) -1, (byte) -1,
        };
        assertEquals(3, PassageKeyFactory.toBinary(buffer, 0, 0, 16777215));
        assertEquals(buffer[0], 0);
        assertEquals(buffer[1], 0);
        assertEquals(buffer[2], 0);
        assertEquals(buffer[3], -1);
        assertEquals(0, PassageKeyFactory.fromBinary(buffer, index, 16777215));
        assertEquals(3, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) -1, (byte) -1, (byte) -1, (byte) -1,
        };
        assertEquals(4, PassageKeyFactory.toBinary(buffer, 0, 0, 16777216));
        assertEquals(buffer[0], 0);
        assertEquals(buffer[1], 0);
        assertEquals(buffer[2], 0);
        assertEquals(buffer[3], 0);
        assertEquals(0, PassageKeyFactory.fromBinary(buffer, index, 16777216));
        assertEquals(4, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) -1, (byte) -1, (byte) -1, (byte) -1,
        };
        assertEquals(4, PassageKeyFactory.toBinary(buffer, 0, 0, 2147483647));
        assertEquals(buffer[0], 0);
        assertEquals(buffer[1], 0);
        assertEquals(buffer[2], 0);
        assertEquals(buffer[3], 0);
        assertEquals(0, PassageKeyFactory.fromBinary(buffer, index, 2147483647));
        assertEquals(4, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) 0, (byte) 0, (byte) 0, (byte) 0,
        };
        assertEquals(1, PassageKeyFactory.toBinary(buffer, 0, 1, 1));
        assertEquals(buffer[0], 1);
        assertEquals(buffer[1], 0);
        assertEquals(buffer[2], 0);
        assertEquals(buffer[3], 0);
        assertEquals(1, PassageKeyFactory.fromBinary(buffer, index, 1));
        assertEquals(1, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) 0, (byte) 0, (byte) 0, (byte) 0,
        };
        assertEquals(1, PassageKeyFactory.toBinary(buffer, 0, 255, 255));
        assertEquals(buffer[0], -1);
        assertEquals(buffer[1], 0);
        assertEquals(buffer[2], 0);
        assertEquals(buffer[3], 0);
        assertEquals(255, PassageKeyFactory.fromBinary(buffer, index, 255));
        assertEquals(1, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) 0, (byte) 0, (byte) 0, (byte) 0,
        };
        assertEquals(2, PassageKeyFactory.toBinary(buffer, 0, 65535, 65535));
        assertEquals(buffer[0], -1);
        assertEquals(buffer[1], -1);
        assertEquals(buffer[2], 0);
        assertEquals(buffer[3], 0);
        assertEquals(65535, PassageKeyFactory.fromBinary(buffer, index, 65535));
        assertEquals(2, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) 0, (byte) 0, (byte) 0, (byte) 0,
        };
        assertEquals(3, PassageKeyFactory.toBinary(buffer, 0, 16777215, 16777215));
        assertEquals(buffer[0], -1);
        assertEquals(buffer[1], -1);
        assertEquals(buffer[2], -1);
        assertEquals(buffer[3], 0);
        assertEquals(16777215, PassageKeyFactory.fromBinary(buffer, index, 16777215));
        assertEquals(3, index[0]);

        index = new int[] {
            0
        };
        buffer = new byte[] {
                (byte) 0, (byte) 0, (byte) 0, (byte) 0,
        };
        assertEquals(4, PassageKeyFactory.toBinary(buffer, 0, 2147483647, 2147483647));
        assertEquals(buffer[0], 127);
        assertEquals(buffer[1], -1);
        assertEquals(buffer[2], -1);
        assertEquals(buffer[3], -1);
        assertEquals(2147483647, PassageKeyFactory.fromBinary(buffer, index, 2147483647));
        assertEquals(4, index[0]);

        index = new int[] {
            2
        };
        buffer = new byte[] {
                (byte) -1, (byte) -1, (byte) -1, (byte) -1,
        };
        assertEquals(1, PassageKeyFactory.toBinary(buffer, 2, 10, 11));
        assertEquals(buffer[0], -1);
        assertEquals(buffer[1], -1);
        assertEquals(buffer[2], 10);
        assertEquals(buffer[3], -1);
        assertEquals(10, PassageKeyFactory.fromBinary(buffer, index, 11));
        assertEquals(3, index[0]);

        for (int i = 0; i < 2147400000; i += 10000) {
            index = new int[] {
                0
            };
            buffer = new byte[] {
                    (byte) 0, (byte) 0, (byte) 0, (byte) 0,
            };
            assertEquals(4, PassageKeyFactory.toBinary(buffer, 0, i, 2147483647));
            assertEquals(i, PassageKeyFactory.fromBinary(buffer, index, 2147483647));
            assertEquals(4, index[0]);
        }
    }

    @Test
    public void testBinaryRepresentation() throws Exception {
        Passage gen1_135 = keyf.getKey(v11n, "Gen 1:1, Gen 1:3, Gen 1:5");
        Passage exo2a_3b = keyf.getKey(v11n, "Exo 2:1-10, Exo 3:1-11");
        Passage gen_rev = keyf.getKey(v11n, "Gen 1:1-Rev 22:21");
        Passage hard = (Passage) keyf.createEmptyKeyList(v11n);
        Passage empty = (Passage) keyf.createEmptyKeyList(v11n);

        for (int i = 1; i < v11n.maximumOrdinal(); i += 10) {
            hard.add(v11n.decodeOrdinal(i));
        }

        byte[] temp = PassageKeyFactory.toBinaryRepresentation(gen1_135);
        Passage gen1_135_copy = PassageKeyFactory.fromBinaryRepresentation(temp);
        assertEquals(gen1_135_copy, gen1_135);
        temp = PassageKeyFactory.toBinaryRepresentation(exo2a_3b);
        Passage exo2a_3b_copy = PassageKeyFactory.fromBinaryRepresentation(temp);
        assertEquals(exo2a_3b_copy, exo2a_3b);
        temp = PassageKeyFactory.toBinaryRepresentation(gen_rev);
        Passage gen_rev_copy = PassageKeyFactory.fromBinaryRepresentation(temp);
        assertEquals(gen_rev_copy, gen_rev);
        temp = PassageKeyFactory.toBinaryRepresentation(hard);
        Passage hard_copy = PassageKeyFactory.fromBinaryRepresentation(temp);
        assertEquals(hard_copy, hard);
        temp = PassageKeyFactory.toBinaryRepresentation(empty);
        Passage empty_copy = PassageKeyFactory.fromBinaryRepresentation(temp);
        assertEquals(empty_copy, empty);
    }
}
