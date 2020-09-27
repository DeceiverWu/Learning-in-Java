package algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the
 * horizontal diameter. Since it's horizontal, y-coordinates don't matter and
 * hence the x-coordinates of start and end of the diameter suffice. Start is
 * always smaller than end. There will be at most 104 balloons.
 *
 * An arrow can be shot up exactly vertically from different points along the
 * x-axis. A balloon with xstart and xend bursts by an arrow shot at x if
 * xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be
 * shot. An arrow once shot keeps travelling up infinitely. The problem is to
 * find the minimum number of arrows that must be shot to burst all balloons.
 *
 * Example:
 *
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * One way is to shoot one arrow for example at x = 6
 * (bursting the balloons [2,8] and [1,6]) and another
 * arrow at x = 11 (bursting the other two balloons).
 *
 * balloons = [[7,10], [1,5], [3,6], [2,4], [1,4]]
 * sorted:
 * balloons = [[2,4], [1,4], [1,5], [3,6], [7,10]]
 * 解题思路: [i, j]
 * 1.按顺序将气球排序
 * 2.每次箭都是从 x = j 射出, 这时候判断每一个气球左端即 i <= x 时在被射范围.
 * 3.当 i > x时, x = j (当前气球右端)
 * 4.循环执行2、3直到最后一个气球
 *
 */
public class MinimumNumberofArrowstoBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) return points.length;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int count = 1;
        int pos = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (pos >= points[i][0]) continue;
            count++;
            pos = points[i][1];
        }
        return count;
    }

}
