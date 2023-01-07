package org.crosswire.jsword.versification;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * JUnit test of Versification classes.
 */
@RunWith(Suite.class)
@SuiteClasses({
    BookNameTest.class,
    BibleNamesTest.class,
    BibleBookListTest.class,
    VersificationTest.class,
    FileVersificationMappingTest.class,
    VersificationsMapperTest.class,
    VersificationToKJVMapperTest.class
})
public class AllTests {
}
