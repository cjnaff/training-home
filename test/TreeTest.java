import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TreeTest {

    private List<Integer> numbers = new ArrayList<Integer>();
    private NavigableSet numberTree;
    @Before
    public void createNumbersTree() {
        numbers = Arrays.asList(50,400,325,20,600,300);
        numberTree = new TreeSet(numbers);
    }

    @Test
    public void testHeadSet() {
        // 2 numbers 20 and 50 are less than 300.
        int size = numberTree.headSet(300)
                .stream()
                .toList().size();
        assertTrue(size == 2);
    }

    @Test
    public void testSubSet() {
        // 325, 300 are in subset  400 is not
        int size = numberTree.subSet(250,400)
                .stream()
                .toList().size();
        assertTrue( size == 2);
    }

    @Test
    public void testLower() {
        numberTree.add(350);
        assertTrue(numberTree.lower(400) .equals(350) );
    }

    @Test
    public void testPolling() {
        System.out.println(numberTree);
//        numberTree.pollFirst();
//        System.out.println(numberTree);
//        numberTree.pollFirst();
//        System.out.println(numberTree);
//        numberTree.pollFirst();
//        System.out.println(numberTree);


        assertTrue( numberTree.pollFirst().equals(20) && numberTree.size() == 5 );
        System.out.println(numberTree);
        assertFalse(numberTree.pollFirst().equals(20) && numberTree.size() == 5 );
        System.out.println(numberTree);
        assertTrue(numberTree.size() == 4 && numberTree.pollFirst().equals(300));
    }


}
