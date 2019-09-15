package algorithm.sort;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 14:47
 */
public class SelectionSort {

    private static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int k = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            if (k != i) {
                arr[k] ^= arr[i];
                arr[i] ^= arr[k];
                arr[k] ^= arr[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = AlgorithmUtils.getRandomArray();
        sort(arr);
        AlgorithmUtils.printArray(arr);
    }
}
