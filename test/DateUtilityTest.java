
import static org.junit.Assert.*;

import java.sql.Date;
//import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;


public class DateUtilityTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetFormattedDateDateString() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public void testGetFormattedDateLocalDateString() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public void testGetFormattedDateLocalDateTimeString() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public void testGetAgeFromDob() {
        assertEquals(10, DateUtility.getAgeFromDob(Date.valueOf("2013-12-14")));
    }

    @Test
    public void testGetAgeFromFutureDob() {
        assertTrue(DateUtility.getAgeFromDob(Date.valueOf("2024-02-20"))<0);
    }

    @Test
    public void testGetAgeFromDobWithCalDate() {
        fail("Not yet implemented"); // TODO
    }

}
