package org.crosswire.jsword.book;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * JUnit Test.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith
 */
@RunWith(Suite.class)
@SuiteClasses({
    BooksTest.class,
    BookMetaDataTest.class,
    SentenceUtilTest.class,
    OsisTest.class
})
public class AllTests {
}
