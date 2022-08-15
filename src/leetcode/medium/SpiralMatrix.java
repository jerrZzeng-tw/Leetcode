package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}).forEach(System.out::print);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> data = new LinkedList<>();
        spiralOrder(matrix, 0, 0, matrix.length - 1, matrix[matrix.length - 1].length - 1, data);
        return data;
    }

    public static void spiralOrder(int[][] matrix, int s_x, int s_y, int e_x, int e_y, List<Integer> data) {
        if ((s_x > e_x || s_y > e_y)) {
            return;
        }
        // to right
        for (int i = s_y; i <= e_y; i++) {
            data.add(matrix[s_x][i]);
        }

        // to down
        for (int i = s_x + 1; i <= e_x; i++) {
            data.add(matrix[i][e_y]);
        }

        // to left
        if (s_x != e_x) {
            for (int i = e_y - 1; i >= s_x; i--) {
                data.add(matrix[e_x][i]);
            }
        }
        // to up
        if (s_y != e_y) {
            for (int i = e_x - 1; i > s_y; i--) {
                data.add(matrix[i][s_y]);
            }
        }
        spiralOrder(matrix, s_x + 1, s_y + 1, e_x - 1, e_y - 1, data);
    }
}
