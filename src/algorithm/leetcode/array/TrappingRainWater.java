package algorithm.leetcode.array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 *
 *   height[i]: 在索引i出条形高度
 * 1.left_max[i]: 存储height在索引i从左到右的每个阶段最大条形高度
 * 2.right_max[i]: 存储height在索引i从右到左的每个阶段最大条形高度
 * 3.遍历height，ans 累加 min(left_max[i],right_max[i])−height[i]
 *
 * left_max与right_max的条形图相交
 * min(left_max[i],right_max[i])为当前点的可以蓄水高度（条形高度+水高度）
 * −height[i]后，为实际水的高度
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }

        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i > 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    public int trap_p(int[] height) {
        if (height.length < 3) return 0;

        int ans = 0;
        int l = 0, r = height.length - 1;
        // find the left and right edge which can hold water
        while (l < r && height[l] <= height[l + 1]) l++;
        while (l < r && height[r] <= height[r - 1]) r--;

        while (l < r) {
            int left_max = height[l];
            int right_max = height[r];
            if (left_max <= right_max) {
                while (l < r && left_max >= height[++l])
                    ans += left_max - height[l];
            } else {
                while (l < r && right_max >= height[--r])
                    ans += right_max - height[r];
            }
        }
        return ans;
    }
}
