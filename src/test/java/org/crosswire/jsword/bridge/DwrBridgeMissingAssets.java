/**
 * Distribution License:
 * JSword is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License, version 2.1 or later
 * as published by the Free Software Foundation. This program is distributed
 * in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * The License is available on the internet at:
 *       http://www.gnu.org/copyleft/lgpl.html
 * or by writing to:
 *      Free Software Foundation, Inc.
 *      59 Temple Place - Suite 330
 *      Boston, MA 02111-1307, USA
 *
 * Copyright: 2008 - 2014
 *     The copyright to this program is held by it's authors.
 *
 */
package org.crosswire.jsword.bridge;

import org.crosswire.jsword.book.BookException;
import org.crosswire.jsword.versification.BookName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test of functionality for use with DWR. This test assumes, at a minimum, that
 * KJV, Strong's Greek and Hebrew Dictionaries, Robinson's morphological codes,
 * ... are installed and that the KJV is indexed.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith
 */
// TODO: make this test use mocks or setup its own environment
public class DwrBridgeMissingAssets {
    DwrBridge dwrBridge = new DwrBridge();

    @Before
    public void setUp() {
        BookName.setFullBookName(true);
    }

    @Test
    public void testIndexed() {
        assertTrue(dwrBridge.isIndexed("KJV"));
        assertFalse(dwrBridge.isIndexed("not a bible")); 
    }

    @Test
    public void testSearch() {
        try {
            String result = dwrBridge.search("KJV", "aaron AND moses AND egypt");
            assertEquals("Exo 5:4, 6:13, 26-27, 7:19, 8:5, 16, 12:1, 16:6, 32:1, Num 14:2, 26:59, 33:1, Jos 24:5, 1Sa 12:6, 8, Mic 6:4, Act 7:40", result);
        } catch (BookException e) {
            fail();
        }
    }
}
