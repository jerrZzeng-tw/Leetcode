package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'1', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku_best(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        // check row
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }

        // check column
        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }

        // check boxes
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                Set<Character> set = new HashSet<>();
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        if (board[i + row][j + col] != '.' && !set.add(board[i + row][j + col])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku_best(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] blo = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int n = 1 << (c - '0'); // 2^n
                int bi = i / 3 * 3 + j / 3;
                // check if any are already set
                if ((row[i] & n) != 0 || (col[j] & n) != 0 || (blo[bi] & n) != 0) {
                    return false;
                }
                // set
                row[i] |= n;
                col[j] |= n;
                blo[bi] |= n;
            }
        }
        return true;
    }
}
