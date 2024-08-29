
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RegexPatternValidatorTest {

    RegexPatternValidator re;

    @Before
    public void setUp(){
        re = new RegexPatternValidator();
    }

    @Test
    public void testValidEmailPattern() {

        assertTrue(re.validEmailPattern("myName@myCo.com"));
    }

    @Test
    public void testInvalidEmailPattern() {
//		assertFalse(re.validEmailPattern("notanemail"));
        assertFalse("Invalid email", re.validEmailPattern("notanemail"));
    }

    @Test
    public void testNotMatchingParens() {
//		assertFalse(re.validEmailPattern("notanemail"));
        String s = "Hi there (hello";
        String[] parts = s.split("[\\(\\)]");
        for (String part : parts) {
            System.out.println(part);
        }
        String returnvalue = "NO";
        char open = '(';
        char closed = ')';
        int countOpen = (int) s.chars().filter(ch -> ch == open).count();
        int countClosed = (int) s.chars().filter(ch -> ch == closed).count();
        switch (s) {
            case  "" -> returnvalue = "YES";
            case String st when (countOpen == countClosed) -> returnvalue = "YES";
            default -> System.out.println("Unable to parse string");
        }
        System.out.println("Is Balanced? " + returnvalue);

        assertFalse("Not Matching", re.validMatchingParentheses(s));
    }

    @Test
    public void testValidRightFaxEmailNameWithPeriod() {
        assertTrue(re.validRightFaxEmailPattern("/name=Dr.Shetab/fax=912097357188@fax.kp.org"));
    }

    @Test
    public void testValidRightFaxDevEmailNameWithSpaces() {
        assertTrue(re.validRightFaxEmailPattern("/name=Dr. Manjari Patel/fax=914088514428@faxdev.kp.org"));
    }

    @Test
    public void testValidRightFaxEmailApostrophe() {
        assertTrue(re.validRightFaxEmailPattern("/name=Dr. Megumi Tomita's Office/fax=912097353224@fax.kp.org"));
    }

    @Test
    public void testValidRightFaxEmailDash() {
        assertTrue(re.validRightFaxEmailPattern("/name=Dr.Hossani-Madani/fax=913016187200@fax.kp.org"));
    }
    @Test
    public void testValidRightFaxNoName() {
        assertTrue(re.validRightFaxEmailPattern("/fax=913016187200@fax.kp.org"));
    }

    @Test
    public void testInvalidRightFaxEmail() {
        assertFalse(re.validRightFaxEmailPattern("/name=Dr.KAZIMIROFF/fax=913238573721@faxd.kp.org"));
    }

    @Test
    public void testStringMatchesPattern() {
        assertTrue("12345", re.stringMatchesPattern("12345", "[0-9]+"));
    }


}
