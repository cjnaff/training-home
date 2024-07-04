
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class JavaUtilDateFormatting {

    static List<Date> dateList = new ArrayList<Date>();
    static SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat dtYYYY = new SimpleDateFormat("YYYY");
    static SimpleDateFormat dtyyyy = new SimpleDateFormat("yyyy");

    public static void main(String args[]) {
        try {
            // working with String array
            String[] dates = {"2021-12-01", "2021-12-26", "2022-01-01"};

            for (String date: dates) {
                System.out.println("For date " + date + " the YYYY year is " + dtYYYY.format(dt.parse(date)) +
                        " while for yyyy it's " + dtyyyy.format(dt.parse(date)));
            }

            Arrays.asList(dates)
                    .stream()
                    .forEach(d -> {
                        try {
                            dt.parse(d);
                            System.out.println("**For date " + d + " the YYYY year is " + dtYYYY.format(dt.parse(d)) +
                                    " while for yyyy it's " + dtyyyy.format(dt.parse(d)));
                        } catch (ParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    })
            ;

            // same as above but as Method Reference
            Arrays.asList(dates)
                    .stream()
                    .forEach(JavaUtilDateFormatting::parseDate)
            ;

            Arrays.asList(dates)
                    .forEach(System.out::println);



        } catch (Exception e) {
            System.out.println("Failed with exception: " + e);
        }

        // Working with List
        initDateList();
        dateList.forEach(d -> {
//			   dtYYYY.format(d);
            System.out.println(dt.format(d));
            System.out.println(dtYYYY.format(d));
        });
        dateList.forEach(System.out::println);

        System.out.println("printing sorted list");
        dateList.stream()
                .sorted()
                .forEach(System.out::println);


    }

    private static void initDateList() {
        try {
            dateList.add(dt.parse("2021-12-26"));
            dateList.add(dt.parse("2023-11-05"));
            dateList.add(dt.parse("2022-06-04"));
            dateList.add(dt.parse("2022-01-01"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    private static void parseDate(String d) {
        try {
            dt.parse(d);
            System.out.println("**For date " + d + " the YYYY year is " + dtYYYY.format(dt.parse(d)) +
                    " while for yyyy it's " + dtyyyy.format(dt.parse(d)));
        } catch (ParseException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
