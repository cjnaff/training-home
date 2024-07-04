
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateUtility {

    public static String getFormattedDate(Date date, String format) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(date);

    }

    // Java 8
    public static String getFormattedDate(LocalDate date, String format) {
        if (date == null) {
            return "";
        }
        return date.format(DateTimeFormatter.ofPattern(format));

    }

    public static String getFormattedDate(LocalDateTime date, String format) {
        if (date == null) {
            return "";
        }
        return date.format(DateTimeFormatter.ofPattern(format));

    }

    public static java.sql.Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static java.sql.Date getBeginningOfTodayPlusX(int days) {
        System.out.println("days = " + days);
        LocalDate localDate = LocalDate.now().plusDays(days);
        return java.sql.Date.valueOf(localDate.atStartOfDay().toLocalDate());

    }

    public static int getAgeFromDob(Date dateFromString) {
        if(dateFromString == null) {
            return 0;
        }
        return Period.between(dateFromString.toLocalDate(), LocalDate.now()).getYears();
    }

    public static int getAgeFromDobWithCal(Date dateOfBirth, Date stopDate) {
        Calendar dob = Calendar.getInstance();
        dob.setTime(dateOfBirth);
        Calendar thenDate = Calendar.getInstance();
        thenDate.setTime(stopDate);
        if (dob.after(thenDate)) {
            return 0;
        }
        int age = thenDate.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (thenDate.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
            age--;
        }
        else if (thenDate.get(Calendar.MONTH) == dob.get(Calendar.MONTH) && thenDate.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
        return age;
    }

    public static int getAgeFromDobWithCal(Date dateOfBirth) {
        Calendar dob = Calendar.getInstance();
        dob.setTime(dateOfBirth);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (dob.after(today)) {
            return 0;
        }
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
            age--;
        }
        else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
        return age;
    }



}
