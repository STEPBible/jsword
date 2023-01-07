// package default;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * JUnit Test.
 */
@RunWith(Suite.class)
@SuiteClasses({
    org.crosswire.jsword.prerequisites.AllTests.class,
    org.crosswire.jsword.book.AllTests.class,
    org.crosswire.jsword.book.filter.thml.AllTests.class,
    org.crosswire.jsword.book.sword.AllTests.class,
    org.crosswire.jsword.bridge.AllTests.class,
    org.crosswire.jsword.index.lucene.analysis.AllTests.class,
    org.crosswire.jsword.passage.AllTests.class,
    org.crosswire.jsword.versification.AllTests.class,
    org.crosswire.jsword.versification.system.AllTests.class
})
public class JSwordAllTests {
}
