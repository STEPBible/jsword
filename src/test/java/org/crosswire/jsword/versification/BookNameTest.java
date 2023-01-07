package org.crosswire.jsword.versification;

import static org.junit.Assert.assertEquals;

import org.crosswire.jsword.book.CaseType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test of BookName
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class BookNameTest {
    private CaseType storedCase;

    @Before
    public void setUp() {
        storedCase = BookName.getDefaultCase();
    }

    @After
    public void tearDown() {
        BookName.setCase(storedCase);
    }

    @Test
    public void testCase() {
        BookName.setCase(CaseType.LOWER);
        assertEquals(CaseType.LOWER, BookName.getDefaultCase());

        BookName.setCase(CaseType.UPPER);
        assertEquals(CaseType.UPPER, BookName.getDefaultCase());

        BookName.setCase(CaseType.SENTENCE);
        assertEquals(CaseType.SENTENCE, BookName.getDefaultCase());
    }

    @Test
    public void testGetBookJogger() throws Exception {
        assertEquals("Gen", BibleBook.GEN.getOSIS());
        assertEquals("Exod", BibleBook.EXOD.getOSIS());
        assertEquals("Rev", BibleBook.REV.getOSIS());
    }

}
