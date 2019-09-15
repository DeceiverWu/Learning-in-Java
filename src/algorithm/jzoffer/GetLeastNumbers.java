package algorithm.jzoffer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:40
 */
public class GetLeastNumbers {

    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length <= 0 || k < 0 || k > input.length) {
            return list;
        }

        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != (k - 1)) {
            if (index < (k - 1)) {
                start = index + 1;
                index = partition(input, start, end);
            } else {
                end = index - 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public int partition(int[] input, int low, int high) {
        int start = low;
        int end = high;
        int key = input[low];

        while (start < end) {
            while (start < end && input[end] >= key) {
                end--;
            }
            input[start] = input[end];
            while (start < end && input[start] <= key) {
                start++;
            }
            input[end] = input[start];
        }
        input[start] = key;
        return start;
    }
}
