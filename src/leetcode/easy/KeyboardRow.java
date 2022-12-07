package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow {
    static final String row1 = "qwertyuiop";
    static final String row2 = "asdfghjkl";
    static final String row3 = "zxcvbnm";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }

    public static String[] findWords(String[] words) {
        List<String> res = new ArrayList<String>();
        for (String word : words) {
            if (isRow(word)) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    public static boolean isRow(String word) {
        // 尋找ROW
        word = word.toLowerCase();
        String s = word.substring(0, 1);
        String row = "";
        if (row1.contains(s)) {
            row = row1;
        } else if (row2.contains(s)) {
            row = row2;
        } else {
            row = row3;
        }
        // 判斷剩下的是否同一個ROW
        for (int i = 1; i < word.length(); i++) {
            if (!row.contains(String.valueOf(word.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
