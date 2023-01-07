package org.crosswire.common.compress;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * JUnit Test.
 */
@RunWith(Suite.class)
@SuiteClasses({
    BZip2Test.class,
    GzipTest.class,
    LZSSTest.class,
    XZTest.class,
    ZipTest.class
})
public class AllTests {
}
