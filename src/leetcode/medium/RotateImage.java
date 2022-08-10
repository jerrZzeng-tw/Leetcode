package leetcode.medium;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        for (int i = 0; i < length; i++) {
            reverse(matrix[i]);
        }
    }

    public static void swap(int[][] matrix, int i, int j, int k, int l) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }

    public static void reverse(int[] nums) {
        int i, k, t;
        for (i = 0; i < nums.length / 2; i++) {
            t = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = t;
        }
    }
}
