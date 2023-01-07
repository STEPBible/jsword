package org.crosswire.common.util;

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
    StringUtilTest.class,
    PropertyMapTest.class,
    LanguageTest.class,
    LanguagesTest.class    
})
public class AllTests {
}
