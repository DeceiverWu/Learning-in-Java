package algorithm.leetcode.array;

/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 *
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 *
 * Note:
 * The given number is in the range [0, 10^8]
 */
public class MaximumSwap {

    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] - '0'] = i;
        }

        int max = 9;
        for (int i = 0; i < nums.length; i++) {
            for (int k = max; k > nums[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = nums[i];
                    nums[i] = nums[buckets[k]];
                    nums[buckets[k]] = tmp;
                    return Integer.valueOf(new String(nums));
                }
            }
        }
        return num;
    }
}
