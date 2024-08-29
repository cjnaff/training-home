import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.*;

public class ArraysTest {
    ArraysPractice arr = new ArraysPractice();




    @Test
    public void getDoubledArray() {
        System.out.println(Arrays.toString(arr.getArray1()));
        System.out.println(Arrays.toString(arr.getArray1Doubled(arr.getArray1())));
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
    public void testStringArrayFilterStartsWith(){
        String[] petsStringArray = {"Piper", "Nori", "Ruff Puff"};
        assertArrayEquals(new String[] {"Ruff Puff"}, arr.filterStringArrByStartsWith(petsStringArray, "R"));
        assertArrayEquals(new String[] {"Nori"}, arr.filterStringArrByStartsWith(petsStringArray, "n"));

    }

    @Test
    public void testRemoveDuplicateAdjacentIntFromArray() {

        int[] nums = new int[] {1,1,2,3,4,4,5}; // Input array
        int[] expectedNums = new int[]{1,2,3,4,5}; // The expected answer with correct length

        int k = arr.removeDuplicateAdjacentValueFromIntArray(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
//        System.out.println(arr.removeDuplicateAdjacentValueFromIntArray(new int[] {1,1,2,3,4,4,5}));
//        System.out.println(arr.removeDuplicateAdjacentValueFromIntArray(new int[] {1,2,4,4,6,6}));

    }

    @Test
    public void testCopyStringArray() {
        String[] strings = {"tree", "grass", "flowers", "water"};

        String[] copiedStrings = (String[]) arr.copyArray(strings);
        assertArrayEquals(strings, copiedStrings);
    }

    @Test
    public void testCopyIntArray() {
        int[] ints = {4,8,15,2};
        // copyArray takes objects, not primatives.  Need solution for that
        int[] intcopy = ints.clone();
        assertArrayEquals(ints, intcopy);
    }

    @Test
    public void testSearchIntArray() {
        int[] intarray = {11,6,4,8,10};
        // binarySearch requires list be sorted.  Once sorted, 11 is in pos 4
        assertEquals( 4, arr.searchIntArrayForAnInt(intarray, 11));
    }
    @Test
    public void testSearchIntArrayNotFound() {
        int[] intarray = {11,6,4,8,10};
        assertTrue(  arr.searchIntArrayForAnInt(intarray, 5) < 0);  // not found returns insertion point as negative
    }
}
