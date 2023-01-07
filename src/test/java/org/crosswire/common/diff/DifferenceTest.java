package org.crosswire.common.diff;

/* Test harness for diff_match_patch.java
 *
 * Version 2.2, May 2007
 * If debugging errors, start with the first reported error, 
 * subsequent tests often rely on earlier ones.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit Test.
 * 
 * Based on the LGPL Diff_Match_Patch v1.5 javascript of Neil Fraser, Copyright (C) 2006<br>
 * <a href="http://neil.fraser.name/software/diff_match_patch/">http://neil.fraser.name/software/diff_match_patch/</a>
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith
 */
public class DifferenceTest {
    @Test
    public void testHashCode() {
        assertTrue("Difference.hashCode:", (new Difference(EditType.EQUAL, "a")).hashCode() == (new Difference(EditType.EQUAL, "a")).hashCode());
        assertFalse("Difference.hashCode:", (new Difference(EditType.EQUAL, "a")).hashCode() == (new Difference(EditType.EQUAL, "ab")).hashCode());
        assertFalse("Difference.hashCode:", (new Difference(EditType.EQUAL, "a")).hashCode() == (new Difference(EditType.INSERT, "a")).hashCode());
    }

    @Test
    public void testEquals() {
        // First check that Diff equality works
        assertTrue("Difference.equals:", new Difference(EditType.EQUAL, "a").equals(new Difference(EditType.EQUAL, "a")));
        assertEquals("Difference.equals:", new Difference(EditType.EQUAL, "a"), new Difference(EditType.EQUAL, "a"));
    }
}
