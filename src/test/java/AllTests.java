// package default;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * JUnit Test.
 */
@RunWith(Suite.class)
@SuiteClasses({
    CommonAllTests.class,
    JSwordAllTests.class
})
public class AllTests {
}
