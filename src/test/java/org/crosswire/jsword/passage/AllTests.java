package org.crosswire.jsword.passage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * JUnit Test.
 */
@RunWith(Suite.class)
@SuiteClasses({
    AccuracyTypeTest.class,
    PassageConstantsTest.class,
    PassageMixTest.class,
    PassageSizeTest.class,
    PassageSpeedOptTest.class,
    PassageSpeedTest.class,
    PassageTallyTest.class,
    PassageTally2Test.class,
    PassageUtilTest.class,
    PassageWriteSpeedTest.class,
    OsisParserTest.class,
    VerseTest.class,
    VerseRangeTest.class,
    TreeKeyTest.class
})
public class AllTests {
}
