package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] data = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {9, 10, 0, 12}};
        setZeroes_best(data);
        System.out.println(Arrays.deepToString(data));
    }

    public static void setZeroes(int[][] matrix) {
        // keep zero index
        List<Integer> zeros = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //                System.out.print(i * n + j);
                //                System.out.print(",");
                if (matrix[i][j] == 0) {
                    zeros.add(i * n + j);
                }
            }
            //            System.out.println();
        }

        // set zero
        for (int data : zeros) {
            Arrays.fill(matrix[data / n], 0);
            int col = (data % n);
            System.out.println(data + "," + col);
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    public static void setZeroes_best(int[][] matrix) {
        boolean row = false;
        boolean column = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                column = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {

            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (column) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }


    }
}
