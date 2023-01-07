package org.crosswire.jsword.passage;

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
