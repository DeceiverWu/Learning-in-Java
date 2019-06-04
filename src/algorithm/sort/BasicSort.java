package algorithm.sort;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 14:50
 */
public class BasicSort {

    public static void basicSort(int[] arr) {
        int len = arr.length;
        int[] bucket = new int[len];

        // initial bucket
        for (int i = 0; i < len; i++) {
            bucket[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }
}
