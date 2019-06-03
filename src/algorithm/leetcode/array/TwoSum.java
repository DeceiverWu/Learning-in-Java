package algorithm.leetcode.array;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-03
 * Time: 18:49
 */

import java.util.Arrays;
import java.util.Map;

/**
 *
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 *  You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *  Example:
 *
 *  Given nums = [2, 7, 11, 15], target = 9,
 *
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 */
public class TwoSum {

    public int[] twoSum1(int[] num, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length; i++){
            int cur = num[i];
            int rest = target - cur;

            if (map.containsKey(rest)){
                result[0] = map.get(rest);
                result[1] = i;
                return result;
            }else{
                map.put(cur, i);
            }
        }
        return result;
    }

    public int[] twoSum2(int[] num, int target){
        int len = num.length;
        int[] arr = Arrays.copyOfRange(num,0, len);

        Arrays.sort(arr);
        for (int i = 0; i < len; i++){
            int index = Arrays.binarySearch(arr, i + 1, len, target - arr[i]);
            if (index >= 0){
                int[] res = new int[2];
                int count = 0;
                for (int j = 0; j < len; j++){
                    if (num[j]==arr[i]||num[j]==arr[index]){
                        res[count]=j;
                        count++;
                        if (count == 2){
                            break;
                        }
                    }
                }
                return res;
            }
        }
        int[] res = {0, 0};
        return res;

    }
}
