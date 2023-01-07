package org.crosswire.jsword.book;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * JUnit Test.
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
