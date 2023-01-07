package org.crosswire.jsword.book;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit Test. For when we don't actually want to do testing of responses
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class BookParentTst {
    protected BookMetaData[] bmds = null;
    protected Book[] bibles = null;

    @Before
    public void setUp() throws Exception {
        List<Book> lbmds = Books.installed().getBooks(BookFilters.getOnlyBibles());
        bibles = new Book[lbmds.size()];
        bmds = new BookMetaData[lbmds.size()];

        int i = 0;
        for (Book book : lbmds) {
            bmds[i] = book.getBookMetaData();
            i++;
        }
    }

    @Test
    public void testNothing() {
        assertTrue(true);
    }
}
