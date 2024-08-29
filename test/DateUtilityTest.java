
import static org.junit.Assert.*;

import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
//import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;


public class DateUtilityTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetFormattedDateDateString() {
        Date newDate = Date.valueOf("2023-05-10");

        //, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        assertTrue(DateUtility.getFormattedDate(newDate, "MM-dd-yyyy").equals("05-10-2023"));


    }

    @Test
    public void testGetFormattedDateLocalDateString() {
        LocalDate lDate = LocalDate.parse("2023-04-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        assertTrue("20230405".equals(DateUtility.getFormattedDate(lDate, "yyyyMMdd")));
    }

    @Test
    public void testGetFormattedDateLocalDateTimeString() {
        LocalDateTime ldt = LocalDateTime.of(2020, 11, 30, 8, 15, 00);
        assertTrue("11-30-2020 08:15:00".equals(DateUtility.getFormattedDate(ldt, "MM-dd-yyyy hh:mm:ss")));

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

    @Test
    public void testExampleQuiz() {
        var localdate = LocalDate.of(2022,3,13);
        var localtime = LocalTime.of(3,0);
        var zone = ZoneId.of("America/New_York");
        var z = ZonedDateTime.of(localdate, localtime, zone);
        System.out.println("Time : " + z.toString());
    // Time : 2022-03-13T03:00-04:00[America/New_York]
//        Time : 2022-03-13T03:00-04:00[America/New_York]
        var p1 = Period.of(1,6,3);  // Period class always takes year, month days
        var p2 = Period.of(1, 2, 1);


        var b = "12";
        b += "3";
//        b.reverse();
        System.out.println(b.toString());

        var line = new StringBuilder("-");
        var anotherline = line.append("-");
        System.out.println(line == anotherline);
        System.out.println(" ");
        System.out.println(line.length());

    }
    public void pi() {
//        byte b = 3.14;
        double d = 3.14;
//        float f = 3.14;
//        short s = 3.14;
    }

}
