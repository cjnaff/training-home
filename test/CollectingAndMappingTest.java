
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.apache.commons.lang3.*;

import io.netty.util.internal.StringUtil;
import org.junit.Before;
import org.junit.Test;



public class CollectingAndMappingTest {

    private CollectingAndMapping cm = new CollectingAndMapping();
    int[] intArray = {300,22,55,38,242,519,22};
    private String allKeys = "";
    private String allValuesSorted = "";
    private String  s = "this a sentance is.";


    @Before
    public void setUp() throws Exception {
        cm.initNumbersList();
        cm.initAnagramStrings();
    }

    @Test
    public void test() {
        assertArrayEquals(intArray, cm.getNumbers().stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void testAverage() {
        assertEquals(Arrays.stream(intArray).average().getAsDouble(), cm.getNumbers().stream().collect(Collectors.averagingInt(Integer::intValue)).doubleValue(), .001);
    }

    @Test
    public void testDoubleWorks() {
        assertNotEquals(cm.getNumbers(), cm.getDoubleAllNumbers());
    }

    @Test
    public void testUniqueList() {
        System.out.println("Unique list " + cm.getUniqueList());
        assertNotEquals(cm.getNumbers(), cm.getUniqueList());
    }

    @Test
    public void testExistsFourNbrDivisibleBy11() {
        System.out.println("divisible by 11 " + cm.getFilteredListDivisibleBy11());

        assertEquals(4, cm.getFilteredListDivisibleBy11().size());
    }

    @Test
    public void testTwoWaysToReverse() {
        // Comparator reverse order uses 'natural order'.  The other method does not sort before it reverses. This test case fails
        System.out.println("Comparator.reverseOrder on List " );
        cm.getNumbers().stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).forEach(System.out::println);
        System.out.println("map using array length (before) " + Arrays.toString(intArray));
/*   Another way to print arrays     for(int i : intArray) {
            System.out.println("int: " + i);
        }*/
        IntStream.rangeClosed(1, intArray.length).map(i -> intArray[intArray.length - i]).forEach(System.out::println);

        assertArrayEquals(cm.getNumbers().stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray(),
                IntStream.rangeClosed(1, intArray.length).map(i -> intArray[intArray.length - i]).toArray());

    }

    @Test
    public void testGrouping() {
        cm.getCountEachInt();
    }

    @Test
    public void checkAnagramsMap() {
        cm.getAnagramStrings().entrySet().forEach(m -> System.out.println("KEY: " +  m.getKey() +  " VALUE: " + m.getValue()  +
                ", sorted: " + Stream.of(m.getKey().split("")).sorted().collect(Collectors.joining()) +
                ", " + Stream.of(m.getValue().split("")).sorted().collect(Collectors.joining())));

        cm.getAnagramStrings().entrySet().forEach(m -> {
            allKeys += Stream.of(m.getKey().split("")).sorted().collect(Collectors.joining());
            allValuesSorted += Stream.of(m.getValue().split("")).sorted().collect(Collectors.joining());
        });
        System.out.println("AllKeysSorted " + allKeys);
        System.out.println("AllValuesSorted " + allValuesSorted);
        assert(allKeys.equalsIgnoreCase(allValuesSorted));
    }

    @Test
    public void testNumberTextValueMap() {
        cm.initFavoriteColorsMap();
        cm.getFavoriteColorsMap().put(4,"stormcloud");
        System.out.println("Map: " + cm.getFavoriteColorsMap().entrySet());
        // switch favorite color by taking it from 1st spot, adding to 3rd spot and then adding 3rd back as 1st
        String favColor = cm.getFavoriteColorsMap().put(3,cm.getFavoriteColorsMap().remove(1));
        cm.getFavoriteColorsMap().put(1,favColor);
        cm.getFavoriteColorsMap().putIfAbsent(1,"cornflower blue");
        System.out.println("Map: " + cm.getFavoriteColorsMap().entrySet());
        assertTrue(cm.getFavoriteColorsMap().get(1).equals("phlox"));
        printType(new SolarBid());
        // Remap key 4 based on evaluation - remapped to null so is removed from the entrySet
        cm.getFavoriteColorsMap().computeIfPresent(4, (k,v) -> v=="stormclout"?v:null);
        System.out.println("Map: " + cm.getFavoriteColorsMap().entrySet());
    }

    @Test
    public void testArrayBinarySearch() {
//        Arrays.
        cm.getSortedNumberList();
    }
    private void printType(Object o) {
        System.out.println("Type " + o.getClass().getTypeName());
    }

    @Test
    public void testSplitStringIntoWords() {
        assertEquals(StringUtils.countMatches(s.toLowerCase().replace(".",""), " is"), 1);
    }

    @Test
    public void testWordCounterMatches() {
       assertTrue( cm.getOccurrencesWordInString("Here is a test. How many words are here?", "here") == 2);
    }

    @Test
    public void testListOfIntegersReversed() {
        List<Integer> sourceList = Arrays.asList(44,3,9,32,2);
        assertEquals(cm.getListOfIntegersReversed(sourceList),Arrays.asList(2,32,9,3,44)) ;
        assertEquals(cm.getListOfIntegersReversedEasier(sourceList), Arrays.asList(2,32,9,3,44));
    // can't do this because max returns Optional, not an int
     //   int i =  sourceList.stream().max(Integer::compare);

        System.out.println(sourceList.stream().sequential());
        // compare returns 1 if x>y, 0 if equal, -1 if less
        sourceList.replaceAll(in -> Integer.compare(2,in));
        System.out.println(sourceList);

        // removeIf returns boolean
        List<Integer> ins = Arrays.asList(3,10,11,5);
        System.out.println(ins.removeIf(i -> i>11));

    }
    @Test
    public void arraysCompareVsMismatch() {
        int[] lista = {4,6,9,11};
        int[] listb = {4,6,9};
        int[] listc = {4,6,9,15};
        int[] listd = {4,9};
        int[] liste = {11,9,6,4};
        int[] listf = {4,6,9,11};
        System.out.println("A to B " + Arrays.compare(lista, listb));
        System.out.println("B to A " +Arrays.compare(listb, lista));
        System.out.println("A to C " +Arrays.compare(lista, listc));
        System.out.println("C to A "+Arrays.compare(listc, lista));
        System.out.println("A to D "+Arrays.compare(lista, listd));
        System.out.println("A to E "+Arrays.compare(lista, liste));
        System.out.println("A to F " + Arrays.compare(lista, listf));
        System.out.println(Arrays.mismatch(lista, listb));
        System.out.println(Arrays.mismatch(lista, listc));
        System.out.println(Arrays.mismatch(lista, listd));
        System.out.println(Arrays.mismatch(lista, lista));

        String[] a1 = {"ant", "ball", "zebra", "ANT"};
        String[] b1 = {"ant", "ball", "cat", "zebra", "ANT"};
        String[] c1 = { "ANT",  "zebra",  "ball", "ant"};
        String[] a2 = {"ant", "ball", "zebra", "ANT"};
        String[] a3 = {"ant", "ball", "ANT", "zebra"};
        System.out.println("strings");
        System.out.println("a1 to b1 " + Arrays.compare(a1, b1));
        System.out.println("a1 to c1 " + Arrays.compare(a1, c1));
        System.out.println("a1 to a2 " + Arrays.compare(a1, a2));
        System.out.println("a1 to a3 " + Arrays.compare(a1, a3));
        System.out.println(Arrays.mismatch(a1, b1));
        System.out.println(Arrays.mismatch(a1, c1));
        System.out.println(Arrays.mismatch(a1, a2));
        System.out.println(Arrays.mismatch(a1, a3));

        System.out.println(1 + 2 + "c");

    }

    @Test
    public void intStreamTest() {
        IntStream in = IntStream.range(1,6);
        // average returns OptionalDouble, which rounds.  Avg is actually 3.5
        System.out.println(in.average());
    }

    @Test
    public void listReduceTest() {
        System.out.println( cm.getSumOfNumbersUsingReduce());
    }

    @Test
    public void testArrayToListIntegers() {
        Integer[] il = {4,8,2,9};
        List<Integer> li = new ArrayList<>();
        li.add(4);
        li.add(8);
        li.add(2);
        li.add(9);
        assertTrue(li.containsAll(cm.integerArrayToList(il)));

        assertTrue(cm.integerArrayToList(il).containsAll(Arrays.stream(il).toList()));
        assertTrue(cm.integerArrayToList(il).equals(li));

        // more int arrays
        int[] nums = {2,5,6,1,9};
        Arrays.stream(nums)
                .forEach(System.out::println);
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        System.out.println("Sum " + numsList.stream().reduce((a,b) -> a+b).get());
        System.out.println("Sum " + numsList.stream().reduce(Integer::sum).get());
        Stream.of(4,6,2,5,6)
                .forEach(i -> System.out.println("num: " + i));

//        Arrays.stream(nums)
//                .collect
    }

}
