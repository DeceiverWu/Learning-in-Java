package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 14:44
 */
public class AlgorithmUtils {

    private AlgorithmUtils() {

    }

    public static void printArray(int[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    public static int[] getRandomArray() {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}
