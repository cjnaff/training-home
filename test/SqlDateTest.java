
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SqlDateTest {


    private static String DateFormat = "yyyyMMdd";
    private static String intStreamRange1 = "";
    private static String intStreamRange2 = "";

    public static void main(String args[]) {
        String[] fieldDescription = {"Nori", "Ruff Puff", "Piper"};
        String[] fieldValue = {"Tan Dog", "Sable Cat", "Grey Cat"};
        String forString = "";
        Map<String, String> pets = new HashMap<String, String>();

        for(int i=0 ; i< fieldDescription.length ; i++) {
            forString += fieldDescription[i] + " : " + fieldValue[i] + "\n";
        }
        System.out.println("forString = " + forString);

        IntStream.range(0, fieldDescription.length)
                .forEach(i -> setRangeString(getRangeString() + fieldDescription[i] + " : " + fieldValue[i] + "\n"));
        System.out.println("intStreamRange1 = " + intStreamRange1);

        IntStream.range(0, fieldDescription.length)
                .forEach(i -> {
                    intStreamRange2 += fieldDescription[i] + " : " + fieldValue[i] + "\n";
                });
        System.out.println("intStreamRange2 = " + intStreamRange2);

        IntStream.range(0,  fieldDescription.length)
                .forEach(i -> pets.put(fieldDescription[i], fieldValue[i]));
        System.out.println("Pets " + pets);


        System.out.println("Age for DOB 10/1/2015, Calendar: " + DateUtility.getAgeFromDobWithCal(getDateFromString("20151001")) + ", java.sql.Date: " + DateUtility.getAgeFromDob(getDateFromString("20151001")));
        System.out.println("Age for DOB 10/1/2018, Calendar: " + DateUtility.getAgeFromDobWithCal(getDateFromString("20181001")) + ", java.sql.Date: " + DateUtility.getAgeFromDob(getDateFromString("20181001")));
        System.out.println("Age for DOB 08/25/2018, Calendar: " + DateUtility.getAgeFromDobWithCal(getDateFromString("20180825")) + ", java.sql.Date: " + DateUtility.getAgeFromDob(getDateFromString("20180825")));
        System.out.println("Age for DOB 08/26/2018, Calendar: " + DateUtility.getAgeFromDobWithCal(getDateFromString("20180826")) + ", java.sql.Date: " + DateUtility.getAgeFromDob(getDateFromString("20180826")));
        System.out.println("Age for DOB 08/27/2018, Calendar: " + DateUtility.getAgeFromDobWithCal(getDateFromString("20180827")) + ", java.sql.Date: " + DateUtility.getAgeFromDob(getDateFromString("20180827")));
        System.out.println("Age for DOB 08/1/2019, Calendar: " + DateUtility.getAgeFromDobWithCal(getDateFromString("20190801")) + ", java.sql.Date: " + DateUtility.getAgeFromDob(getDateFromString("20190801")));
        System.out.println("Age for DOB 07/1/2019, Calendar: " + DateUtility.getAgeFromDobWithCal(getDateFromString("20190701")) + ", java.sql.Date: " + DateUtility.getAgeFromDob(getDateFromString("20190701")));


    }


/*private static void appendRangeString(String value) {
	setRangeString(getRangeString() + value);

}*/





    public static Date getDateFromString(String dateString) {
        try {
            return new java.sql.Date(new SimpleDateFormat(DateFormat).parse(dateString).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getRangeString() {
        return intStreamRange1;
    }


    public static void setRangeString(String rangeString) {
        SqlDateTest.intStreamRange1 = rangeString;
    }

}
