
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;



public class LambdaExercises {

    static int i = 1;


    public static void main(String[] args) {


        System.out.println("1 is odd " + isOdd(1));

        boolean b = isOddTest.test(i);
        System.out.println("isOddTest result: " + b);

        // implement Runnable lambda to iterate i then use Predicate lambda to check if i is odd.
        Runnable r = () ->  i++;
        r.run();
        System.out.println("i = " + i + " is odd? " + isOddTest.test(i));

        r.run();
        System.out.println("i = " + i + " is odd? " + isOddTest.test(i));
        r.run();
        r.run();
        System.out.println("i = " + i + " is odd? " + isOddTest.test(i));

        // use lambda expression within a lambda implementation
        System.out.println("today is " + getToday.get() + " in month " + getMonth.get());



        System.out.println("Hello everyone!");
        LocalDateTime t = LocalDateTime.now()  ;
        System.out.println("z2 " + ZonedDateTime.now().getZone() ) ;
        System.out.println(t);


        String s = "Summer";

//        System.out.println("String: " + s + ", reversed " + Arrays.reversed(s));

        arrayWork();

    }

    public static  void arrayWork() {

        int[] arr = {9,14,3,2,43,11,58,22};
        List<int[]> newArr = Arrays.asList(arr).stream()
                .sorted().collect(Collectors.toList()).reversed();
//        newArr.stream().forEach(System.out::println);
        List<Integer> iList = Arrays.stream(arr).sorted().boxed().toList();
        System.out.println("Reversed " + iList.reversed().get(1));
//        Arrays.asList(arr).stream()
//                .forEachOrdered()
//                .;

        int[] arr2 = {9,14,3,2,43,11,58,22};
//        int[] leader2 = ( arr2 -> (a,b) )
//        Arrays.stream(arr2).
//                .forEach(i -> System.out.println(i));
        int[] leaders = new int[arr2.length];
 /*       for(int i : arr2) {
            if(i > arr2[i+1]) {
                leaders[i] += i;
            }*/
//        }
        System.out.println(Arrays.toString(leaders));

    }
    static Predicate<Integer> isOddTest = s -> s%2 != 0;

    static Supplier<LocalDate> getToday = () -> LocalDate.now();
    static Supplier<LocalDate> getToday2 = LocalDate::now;  // using method reference
    //	static Supplier<Month> getMonth = () -> LocalDate.now().getMonth();
    static Supplier<Month> getMonth = () -> getToday.get().getMonth();





    private static boolean isOdd(int i) {
        return ( i%2 != 0);
    }



}
