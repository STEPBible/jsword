package org.crosswire.jsword.book.sword;

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
    BackendTest.class,
    ConfigEntryTableTest.class,
    RawFileBackendTest.class,
    SwordBookDriverTest.class,
    SwordBookMetaDataTest.class,
    SwordBookTest.class
})
public class AllTests {
}
