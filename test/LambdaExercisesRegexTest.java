

import java.util.function.Supplier;

import static org.junit.Assert.*;

import org.junit.Test;

public class LambdaExercisesRegexTest {
    // Lambda expressions using Supplier
    static Supplier<String> getRightFaxRegex = () -> "(^/name=[A-Za-z_.'\\- ]+)?/fax=[0-9]+@fax(dev)?\\.kp\\.org";
    static Supplier<String> getEmailRegex = () ->  "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    static Supplier<String> getNumberRegex = () -> "[0-9]+";
    static Supplier<String> getLettersRegex = () -> "[_A-Za-z-]+";

    // Lambda expression using my functional interface that takes a new RegexPatternValidator. This is the implementation:
    static RegexPatternChecker checkPattern = (v) -> v.getMatcher().matches();

    public static void main(String[] args) {
        System.out.println("90291 matches getNumberRegex " + stringMatchesPattern("90291", getNumberRegex ));
    }


    /**
     * @param s string
     * @param p pattern
     * @return string matches pattern
     */
    private static boolean stringMatchesPattern(String s, Supplier<String> p) {
        RegexPatternValidator v = new RegexPatternValidator( p.get(), s);
        return v.getMatcher().matches();
    }

    //Test using my functional interface
    @Test
    public void testPatternChecker() {
        assertTrue(checkPattern.checkStringMatchesPattern(new RegexPatternValidator(getEmailRegex.get(), "testperson@kp.org")));
    }

    // tests using Supplier lambdas
    @Test
    public void testValidEmail() {
        assertTrue(stringMatchesPattern("testperson@kp.org", getEmailRegex));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(stringMatchesPattern("testperson@kp", getEmailRegex));
    }

    @Test
    public void testValidRightFax() {
        assertTrue(stringMatchesPattern("/fax=829382910@fax.kp.org", getRightFaxRegex));
    }

    @Test
    public void testValidRightFaxWithName() {
        assertTrue(stringMatchesPattern("/name=Mary Jane/fax=899229922@faxdev.kp.org", getRightFaxRegex));
    }

    @Test
    public void testInvalidRightFax() {
        assertFalse(stringMatchesPattern("89929222822@fax.kp.org", getRightFaxRegex));
    }

    @Test
    public void testEmailAsRightFax() {
        assertFalse(stringMatchesPattern("BillyBobbit@kp.org", getRightFaxRegex));
    }

    @Test
    public void testLettersOnly() {
        assertTrue(stringMatchesPattern("kslKSWW", getLettersRegex));
    }

    @Test
    public void testMixedStringNotLetters() {
        String s = "jskJJ00332";
        assertFalse(stringMatchesPattern(s, getLettersRegex)) ;
    }
}
