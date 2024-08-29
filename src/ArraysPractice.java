import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysPractice {

/*
int[] myIntArray = {1, 2, 3};
int[] myIntArray = new int[]{1, 2, 3};
int [] myIntArray = IntStream.range(0, 100).toArray();
int [] myIntArray = IntStream.rangeClosed(0, 100).toArray();
int [] myIntArray = IntStream.of(12,25,36,85,28,96,47).toArray();
Print Array:  Arrays.toString(nums);
 */

    int[] array1 = {99,2,6,44,3};
    int[] array2;



    public int[] getArray1() {
        return array1;
    }

    public int[] getArray2() {
        return array2;
    }

    public int[] getArray1Doubled(int[] nums) {
        int[] nums2 = ArrayUtils.add(nums, nums[0]);
        return nums2;
    }

    public void arrayQuestion() {
        int[] numbers = {5, 3, 9, 7, 2, 8};

        var result = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst();

        result.ifPresentOrElse(
                value -> System.out.println(value),
                () -> { throw new IllegalArgumentException("Array too small"); }
        );

     /*   A. Finds the maximum number in the numbers array.
        B. Finds the second maximum number in the numbers array.
                C. Sorts the numbers array in descending order.
        D. Throws an exception if the array size is less than 2.
        */

    }

    public void intAndIntegers() {
        int[] numbers = {5, 3, 9, 7, 2, 8};

        var result = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst();



        Integer[] ints =  Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        System.out.println("Integer Array: " + Arrays.stream(ints).toList());

        NavigableSet<Integer> ins = new TreeSet<>(Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList()));

        System.out.println(ins);

        Set<Integer> lhs = new LinkedHashSet<Integer>( Arrays.stream(numbers).boxed().toList());
        System.out.println(lhs);
    }

    public Object[] filterStringArrByStartsWith(String[] sa, String letter) {
        return  Arrays.stream(sa)
                .filter(s -> s.toUpperCase().startsWith(letter.toUpperCase()))
                .toArray();
    }

    public int removeDuplicateAdjacentValueFromIntArray(int[] nums) {

/*
Input
nums =
[0,0,1,1,1,2,2,3,3,4]
Output
[0,0,1,1,1]
Expected
[0,1,2,3,4]
         */
   /*         // brute force // putting nums without skipping place
            int countUniqueNums = 0;
            int[] expectedNums = new int[nums.length] ;
            for(int i = 1 ; i < nums.length ; i++) {
                if(nums[i-1] != nums[i]) {
                    expectedNums[countUniqueNums] = nums[i-1];
                    countUniqueNums++;

                }
            }
            if(nums[nums.length-1] != expectedNums[countUniqueNums]){
                expectedNums[countUniqueNums] = nums[nums.length-1];
            }
        System.out.println("Before: " + Arrays.toString(nums) + "After: " + Arrays.toString(expectedNums));
            return countUniqueNums + 1;*/

        // brute force // putting nums skipping place
        int countUniqueNums = 0;
        int[] expectedNums = new int[nums.length] ;
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i-1] != nums[i]) {
                expectedNums[i-1] = nums[i-1];
                countUniqueNums++;

            }
        }
        if(nums[nums.length-1] != expectedNums[countUniqueNums]){
            expectedNums[nums.length-1] = nums[nums.length-1];
        }
        System.out.println("Before: " + Arrays.toString(nums) + "After: " + Arrays.toString(expectedNums));
        return countUniqueNums + 1;

    }

    public Object[] copyArray(Object [] orig) {
//        Object[] copy =
//        Object[] copy = new Object[orig.length];
//        System.arraycopy(orig, 0, copy, 0, orig.length);

        return orig.clone(); // this way retains array type avoiding class cast exception
    }

    public int searchIntArrayForAnInt(int[] array1, int searchInt) {
        Arrays.sort(array1);
        return Arrays.binarySearch(array1, searchInt);
    }
}
