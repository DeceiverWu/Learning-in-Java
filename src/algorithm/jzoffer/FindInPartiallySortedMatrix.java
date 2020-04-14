package algorithm.jzoffer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:30
 */
public class FindInPartiallySortedMatrix {

    /**
     * 二维数组中的查找
     * 1  2  8  9
     * 2  4  9  12
     * 4  7  10 13
     * 6  8  11 15
     */
    public boolean find(int[][] matrix, int rows, int columns, int target) {
        if (matrix == null || rows < 0 || columns < 0)
            return false;

        boolean found = false;
        while (matrix != null && rows > 0 && columns > 0) {
            if (matrix[rows][columns] == target) {
                found = true;
                break;
            } else if (matrix[rows][columns] > target) {
                columns--;
            } else {
                rows++;
            }
        }
        return found;
    }

    public boolean find1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int cols = matrix[0].length -1;
        int r = 0;
        boolean found = false;
        while (r <= rows - 1 && cols >= 0) {
            if (matrix[r][cols] == target) {
                found = true;
                break;
            } else if (matrix[r][cols] > target) {
                cols--;
            } else {
                r++;
            }
        }
        return found;
    }
}
