package algorithm.leetcode.array;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-03
 * Time: 19:14
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // finding first decreasing element
        while (i > 0 && nums[i + 1] < nums[i]) {
            i--;
        }

        // finding a number just larger than first found element
        if (i >= 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // reverse these number whose index larger than first found element
        reverse(nums, i + 1);
    }

    private void reverse(int[] arr, int start) {
        int i = start;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
