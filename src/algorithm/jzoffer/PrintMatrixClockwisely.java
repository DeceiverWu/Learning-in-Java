package algorithm.jzoffer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 11:50
 */
public class PrintMatrixClockwisely {


    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int row = 0;
        int col = 0;

        while (row <= rows && col <= cols) {
            // left -> right
            for (int i = col; i <= cols; i++) {
                list.add(matrix[row][i]);
            }

            // top -> bottom
            if (row < rows) {
                for (int i = row + 1; i <= rows; i++) {
                    list.add(matrix[i][cols]);
                }
            }

            // right -> left
            if (col < cols && row < rows) {
                for (int i = cols - 1; i >= col; i--) {
                    list.add(matrix[rows][i]);
                }
            }

            // bottom -> top
            if (row < rows && col < cols) {
                for (int i = rows - 1; i >= row + 1; i--) {
                    list.add(matrix[i][col]);
                }
            }

            // Reduce the clockwise range
            row++;
            col++;
            cols--;
            rows--;
        }
        return list;
    }
}
