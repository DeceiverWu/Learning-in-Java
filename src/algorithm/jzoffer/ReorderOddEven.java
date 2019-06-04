package algorithm.jzoffer;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:52
 */
public class ReorderOddEven {

    /**
     * 奇数位于偶数前面
     * @param nums
     * @param length
     */
    public static void reorderOddEven(int[] nums, int length){
        if (nums == null || length == 0)
            return;

        int start = 0;
        int end = length - 1;
        while (start < end){
            while (start < end && (nums[start] & 1) != 0){
                start++;
            }
            while (start < end && (nums[end] & 1) == 0){
                end--;
            }
            if (start < end){
                nums[start] ^= nums[end];
                nums[end] ^= nums[start];
                nums[start] ^= nums[end];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        reorderOddEven(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    private interface ReorderStrage {
        boolean getRole(int num);
    }

    class IsEven implements ReorderStrage {

        @Override
        public boolean getRole(int num) {
            return (num & 1) == 0;
        }
    }
    /**
     * 可扩展性方法
     * @param nums
     * @param length
     * @param strage 为接口，具体实现类具有相同方法，不同的定义
     */
    public void reorderOddEven(int[] nums, int length, ReorderStrage strage){
        if (nums == null || length == 0)
            return;

        int start = 0;
        int end = length - 1;
        while (start < end){
            while (start < end && strage.getRole(nums[start])){
                start++;
            }
            while (start < end && strage.getRole(nums[end])){
                end--;
            }
            if (start < end){
                nums[start] ^= nums[end];
                nums[end] ^= nums[start];
                nums[start] ^= nums[end];
            }
        }
    }
}
