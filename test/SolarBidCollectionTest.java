

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static org.junit.Assert.*;

public class SolarBidCollectionTest {

    private static Collection<SolarBid> immutableBidsList;
    private static Collection<SolarBid> bids;

    SolarBid smartWaveBid = new SolarBid("SmartWave Solar", 26780, 8.2, 20, 10562);
    SolarBid energyAdvantage = new SolarBid("Energy Advantage", 28720, 7.22, 19, 10168);
    SolarBid namaste = new SolarBid("Namaste Solar", 36494, 9.02, 22, 9662);
    SolarBid solarSideUp = new SolarBid("Solar Side Up", 26977, 7.38, 18, 8241);

    SolarRep dallin = new SolarRep("Dallin");
    SolarRep sean = new SolarRep("Sean Gregory");
    SolarRep david = new SolarRep("David");




    @Before
    public void initializeSolarBids() {


        immutableBidsList = List.of(smartWaveBid, energyAdvantage, namaste, solarSideUp);

//        immutableBidsList.forEach(System.out::println);

/*        System.out.println("Cost Analysis: "  +  immutableBidsList.stream()
                .mapToDouble(b -> b.getCost())
                .summaryStatistics());*/

        bids = new ArrayList<>(immutableBidsList);  // use constructor
//        bids.addAll(immutableBidsList.stream().toList());
//        bids.forEach(System.out::println);


    }


/* java.lang.UnsupportedOperationException  */
    private boolean removeBid(String companyName) {
       return  bids.removeIf(b -> b.getCompanyName().equalsIgnoreCase(companyName));
    }

    @Test
    public void testRemoveBid() {
        System.out.println("** Removing SolarSideUp");
        removeBid("Solar Side Up");
        bids.forEach(System.out::println);
        assertFalse(bids.stream().anyMatch(b -> b.getCompanyName().equalsIgnoreCase("Solar Side Up")));
    }

    @Test
    public void testRemoveNonExistantBidDoesnotFail() {
        assertFalse(removeBid("Fictional Solar Co"));
    }

    @Test
    public void testAbleToAddRemoveBid() {
        bids.add(new SolarBid("New CO", 50000, 8.55, 20, 10200));
        assertTrue(removeBid("New CO"));
    }

    @Test
    public void testRetainOnlyCheapestBids() {
        System.out.println("** Keeping cheapest");
        bids.add(new SolarBid("New CO", 20000, 8.55, 20, 10200));
        int origSize = bids.size();
        OptionalDouble avgCost = bids.stream().mapToDouble(b1 -> b1.getCost()).average();
        System.out.println("Average Cost: " + avgCost);
        bids.retainAll(bids.stream()
                .filter(b -> b.getCost() < avgCost.getAsDouble())
                .toList());
        bids.forEach(System.out::println);
        assertTrue(bids.size() < origSize);
        assertTrue(bids.stream().allMatch(b -> b.getCost() <= avgCost.getAsDouble()));
    }

//    add this code?  https://www.geeksforgeeks.org/method-references-in-java-with-examples/
    @Test
    public void testConstructorMethodReference() {
        // method reference using constructor on SolarBid that takes a String
        List<String> newCompanies = List.of("CompanyA", "CompanyB", "CompanyC");
       SolarBid[] coArray1 = newCompanies.stream()
                .map(SolarBid::new)
                .toArray(SolarBid[]::new);


        // same code using Lambda instead of method reference
        SolarBid[] coArray2 = newCompanies.stream()
                .map(companyName -> new SolarBid(companyName))
                .toArray(value -> new SolarBid[value]);
        assertEquals(coArray1, coArray2);
    }

    @Test
    public void addNewBidLinkedList() {

        List<SolarBid> linkedBids = new LinkedList<SolarBid>();
        linkedBids.addAll(bids);
        System.out.println("LinkedBids: " + linkedBids);
        SolarBid newCo = new SolarBid("New CO", 20000, 8.55, 20, 10200);
        linkedBids.add(1,newCo);
        System.out.println("Modified LinkedBids: " + linkedBids);
        linkedBids.remove(newCo);
        linkedBids.set(3,newCo);
        System.out.println("New LinkedBids: " + linkedBids);

    }

    @Test
    public void testBidPriorityQueue() {
        Comparator<SolarBid> bidPriority = Comparator.comparing(SolarBid::getCost);
        Queue<SolarBid> queue = new PriorityQueue<SolarBid>(bidPriority);  // using comparitor for order
//        Queue<SolarBid> queue = new ArrayDeque<>(); // FIFO
        queue.add(namaste);
        queue.add(solarSideUp);
        queue.add(smartWaveBid);
        queue.add(energyAdvantage);
        System.out.println("Queue using cost as priority: " + queue);
    }

    @Test
    public void testMapKeyComparatorIsWorking() {
        Map<SolarRep, SolarBid> repsBids = new HashMap<>();  // no particular order
        repsBids.put(dallin, smartWaveBid);
        repsBids.put(sean, energyAdvantage);
        repsBids.put(david, namaste);

        // returns null if hashcode and equals aren't implemented to show that David = David.
        System.out.println("Namaste " + repsBids.get(new SolarRep("David")));
        assertEquals(repsBids.get(david), repsBids.get(new SolarRep("David")));
        assertEquals(namaste, repsBids.get(new SolarRep("David")));
    }

    @Test
    public void testSortedSetUsingComparable() {
        Set<SolarBid> set = new HashSet<>();
        set.add(solarSideUp);
        set.add(namaste);
        set.add(smartWaveBid);
        set.add(energyAdvantage);

        set.stream()
                .sorted()
                .forEach(System.out::println);

    assertEquals(set.toArray()[0], energyAdvantage);  // Energy Advantage is first on sort

    }

    @Test
    public void testTreeSet() {
        Set<SolarBid> trees = new TreeSet<>();
        trees.add(energyAdvantage);
        trees.add(solarSideUp);
        trees.add(namaste);
        trees.add(smartWaveBid);


    }

    @Test
    public void testCollectors(){
        bids.stream()
                .collect(Collectors.groupingBy(b -> b.getSize() >= 8,
                        mapping(SolarBid::getCompanyName, Collectors.counting())))
                        .forEach((c,d) -> System.out.println(c + ": " + d));

        bids.stream()
                .collect(Collectors.partitioningBy(b -> b.getSize() >= 8,
                                mapping(SolarBid::getCompanyName, Collectors.toList())))
                .forEach((c,d) -> System.out.println(c + ": " + d));

        bids.stream()
                .collect(Collectors.groupingBy(b -> b.getSize() >= 8,Collectors.counting()))
                .forEach((c,d) -> System.out.println(c + ": " + d));

        bids.stream()
                .collect(Collectors.partitioningBy(b -> b.getSize() >= 8, Collectors.counting()))
                .forEach((c,d) -> System.out.println(c + ": " + d));

        bids.stream()
                .collect(Collectors.groupingBy(b -> b.getPanelCount(),Collectors.counting()))
                .forEach((c,d) -> System.out.println(c + ": " + d));

//        bids.stream()
//                .collect(Collectors.partitioningBy(b -> b.getPanelCount(), Collectors.counting()))
//                .forEach((c,d) -> System.out.println(c + ": " + d));

        List<Integer> l = Arrays.asList(0, 0);
        l.set(1, 8);
        l.set(0, 6);
        System.out.println(l);
    }
}


