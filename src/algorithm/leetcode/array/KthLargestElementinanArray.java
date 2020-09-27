package algorithm.leetcode.array;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int j = partition(nums, low, high);
            if (j < k)
                low = j + 1;
            else if (j > k)
                high = j - 1;
            else break;
        }
        return nums[k];
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int findKthLargest1(int[] nums, int k) {
        if(nums == null) return -1;
        return helper(nums, 0, nums.length-1, k);
    }

    int helper(int[] nums, int start, int end, int k){
        if(start == end) return nums[start];
        int left = start;
        int right = end;
        int pivot = nums[left + (right - left)/2];
        while(left <= right){
            while(left <= right && nums[left] > pivot) left++;
            while(left <= right && nums[right] < pivot) right--;
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if(start + k -1 <= right) return helper(nums, start, right, k);
        if(start + k-1 >= left) return helper(nums, left, end, k-(left-start));
        return nums[right+1];
    }
}
