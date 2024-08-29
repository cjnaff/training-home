import junit.framework.TestCase;
import org.junit.Test;

public class StaticInheritanceTestTest extends TestCase {
    StaticInheritanceTest newTest = new StaticInheritanceTest();
    @Test
    public void testStaticTest() {

        newTest.new ChildClass().main(null);



    }

}