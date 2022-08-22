package leetcode.medium;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "SEE"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[i].length)
            return false;

        if (board[i][j] == word.charAt(index)) {
            char temp = board[i][j];
            board[i][j] = '*';
            if (exist(board, word, index + 1, i - 1, j) || exist(board, word, index + 1, i, j - 1) || exist(board, word,
                    index + 1, i + 1, j) || exist(board, word, index + 1, i, j + 1)) {
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
}


