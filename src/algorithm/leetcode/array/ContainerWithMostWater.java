package algorithm.leetcode.array;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * rea = length of shorter vertical line * distance between lines
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                maxArea = Math.max(h * (j - i), maxArea);
            }
        }
        return maxArea;
    }

    public int maxArea_p(int[] height) {
        int maxArea = 0;
        int low = 0, right = height.length - 1;
        while (low < right) {
            maxArea = Math.max(maxArea, Math.min(height[right], height[low]) * (right - low));
            if (height[right] > height[low]) {
                low++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
