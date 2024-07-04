import org.junit.Test;

import java.util.Arrays;

public class ArraysTest {
    ArraysPractice arr = new ArraysPractice();


    @Test
    public void getDoubledArray() {
        System.out.println(Arrays.toString(arr.getArray1()));
        System.out.println(Arrays.toString(arr.getArray1Doubled(arr.getArray1())));

    }
}
