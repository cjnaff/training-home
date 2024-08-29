import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TreeDequeuTest {

    private List<Integer> numbers = new ArrayList<Integer>();
    private NavigableSet numberTree;
    private CodeChallenges ts = new CodeChallenges();

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
    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[] {1,2}, ts.twoSum(new int[] {3,2,4}, 6));
        System.out.println(ts.twoSum(new int[] {4,9,2,6,3}, 6));
        assertArrayEquals(new int[] {0,1}, ts.twoSum(new int[] {2,7,11,15}, 9));
        assertArrayEquals(new int[] {0,1}, ts.twoSum(new int[] {3,3}, 6));
    }
    
    @Test
    public void testCommonWordSuffix() {
        assertEquals("a", ts.commonWordSuffix(new String[] {"ab", "a"}));
        assertEquals("fl", ts.commonWordSuffix(new String [] {"flower","flow","flight"}));
        assertEquals("bo", ts.commonWordSuffix(new String[] {"boy", "boat", "book"}));
        assertEquals("the", ts.commonWordSuffix(new String[] {"theater", "them", "theme"}));
        assertEquals("", ts.commonWordSuffix(new String[] {"theater", "boat", "none"}));
        assertEquals("theater", ts.commonWordSuffix(new String[] {"theater"}));
        assertEquals("", ts.commonWordSuffix(null));
        assertEquals("", ts.commonWordSuffix(new String[] {""}));
        assertEquals("", ts.commonWordSuffix(new String[] {"", ""}));
    }
    @Test
    public void testParenthesisValid() {
        assertFalse(ts.isValidParentheses("Hello (hi) twice (hi"));
        assertTrue(ts.isValidParentheses("Set of (parentheses)"));
        assertTrue(ts.isValidParentheses("Set of {curly braces}"));
        assertTrue(ts.isValidParentheses("Set of [brackets]"));

        assertFalse(ts.isValidParenthesesOnly("())"));
        assertTrue(ts.isValidParenthesesOnly("()"));
        assertTrue(ts.isValidParenthesesOnly("{}"));
        assertTrue(ts.isValidParenthesesOnly("[]"));
        assertFalse(ts.isValidParenthesesOnly("[}"));
    }

    @Test
    public void testListMerge() {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2);

        ListNode ll1 = new ListNode(5);
        ListNode ll2 = new ListNode(3, ll1);
        ListNode ll3 = new ListNode(1, ll2);

        assertEquals(ts.flattenNestedListNodeValuesToList(ll3), ts.flattenNestedListNodeValuesToList( ts.generateNestedListNodesFromList(Arrays.stream(new Integer[] {1,3,5}).toList())));
//        ts.mergeTwoLists(l3, ll3);
        System.out.println("Merged List: " + ts.mergeTwoLists(l3, ll3));
        System.out.println("Merge {3,5,2} {1,9,4,3} " + ts.mergeTwoListsMyWay3(ts.generateNestedListNodesFromList(Arrays.stream(new Integer[] {3,5,2}).toList()),
                ts.generateNestedListNodesFromList(Arrays.stream(new Integer[] {1,9,4,3}).toList()) ));

        System.out.println("Merge {} {0} " + ts.mergeTwoListsMyWay3(ts.generateNestedListNodesFromList(Arrays.stream(new Integer[] {}).toList()),
                ts.generateNestedListNodesFromList(Arrays.stream(new Integer[] {0}).toList()) ));

        System.out.println("My Sorted Set: " + ts.mergeTwoListsMyWay3(l3, ll3));
        System.out.println("Flattened List: " + ts.flattenNestedListNodeValuesToList(ll3));
    }



/*   ( 5, (3, (1, null)))
*   (1, null)
*
*
* */
}
