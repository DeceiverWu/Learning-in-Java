package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 *
 * In one shift operation:
 *
 * Element at grid[i][j] moves to grid[i][j + 1].
 * Element at grid[i][n - 1] moves to grid[i + 1][0].
 * Element at grid[m - 1][n - 1] moves to grid[0][0].
 * Return the 2D grid after applying shift operation k times.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 */
public class Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int tmp[][] = new int[row][col];
        List<List<Integer>> res = new ArrayList<>();
        k = k % (row * col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int c = j + k;
                int r = c / col;
                if (c < col) {
                    tmp[i][c] = grid[i][j];
                } else {
                    tmp[(i + r) % row][c % col] = grid[i][j];
                }
            }
        }

        for (int[] rows : tmp) {
            List<Integer> c = new ArrayList<>();
            for (int i : rows)
                c.add(i);
            res.add(c);
        }

        return res;
    }
}
