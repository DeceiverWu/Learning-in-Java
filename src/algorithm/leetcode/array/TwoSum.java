package algorithm.leetcode.array;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-03
 * Time: 18:49
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public int[] twoSum(int[] num, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            int cur = num[i];
            int rest = target - cur;

            if (map.containsKey(rest)) {
                result[0] = map.get(rest);
                result[1] = i;
                return result;
            } else {
                map.put(cur, i);
            }
        }
        return result;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] list = new int[4096];
        int[] result = new int[2];
        int key;
        for(int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            key = tmp & 4095;
            if (list[key] != 0) {
                return new int[] {list[key] - 1, i};
            }
            list[nums[i] & 4095] = i + 1;
        }
        return result;
    }

}
