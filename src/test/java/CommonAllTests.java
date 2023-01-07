// package default;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * JUnit Test.
 */
@RunWith(Suite.class)
@SuiteClasses({
    org.crosswire.common.compress.AllTests.class,
    org.crosswire.common.diff.AllTests.class,
    org.crosswire.common.history.AllTests.class,
    org.crosswire.common.icu.AllTests.class,
    org.crosswire.common.progress.AllTests.class,
    org.crosswire.common.xml.AllTests.class,
    org.crosswire.common.util.AllTests.class
})
public class CommonAllTests {
}
