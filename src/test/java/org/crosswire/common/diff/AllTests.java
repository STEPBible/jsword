package org.crosswire.common.diff;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * JUnit Test.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
@RunWith(Suite.class)
@SuiteClasses({
    BitapTest.class,
    CommonalityTest.class,
    DiffCleanupTest.class,
    DifferenceEngineTest.class,
    DifferenceTest.class,
    DiffTest.class,
    LineMapTest.class,
    MatchTest.class,
    PatchEntryTest.class,
    PatchTest.class
})
public class AllTests {
}
