import org.apache.commons.lang3.ArrayUtils;

public class ArraysPractice {



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
}
