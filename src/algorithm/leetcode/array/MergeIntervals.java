package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 *
 *
 * Constraints:
 *
 * intervals[i][0] <= intervals[i][1]
 *
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        int[] tmp = intervals[0];
        res.add(tmp);
        for (int[] interval : intervals) {
            if (interval[0] <= tmp[1])
                tmp[1] = Math.max(tmp[1], interval[1]);
            else {
                tmp = interval;
                res.add(tmp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
