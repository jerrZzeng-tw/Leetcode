package leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        letterCombinations("").forEach(System.out::println);
    }

    public static List<String> letterCombinations(String digits) {
        char[] ar = digits.toCharArray();
        String[] res = new String[]{};
        for (char c : ar) {
            res = combine(res, getStr(c));
        }
        return Arrays.asList(res);
    }

    public static String[] combine(String[] s1, String[] s2) {
        if (s1.length == 0) {
            return s2;
        } else if (s2.length == 0) {
            return s1;
        }
        String[] res = new String[s1.length * s2.length];
        int index = 0;
        for (String val1 : s1) {
            for (String val2 : s2) {
                res[index++] = val1 + val2;
            }
        }
        return res;
    }

    public static String[] getStr(Character c) {
        char c1 = c == null ? 'a' : c;
        switch (c1) {
            case '2':
                return new String[]{"a", "b", "c"};
            case '3':
                return new String[]{"d", "e", "f"};
            case '4':
                return new String[]{"g", "h", "i"};
            case '5':
                return new String[]{"j", "k", "l"};
            case '6':
                return new String[]{"m", "n", "o"};
            case '7':
                return new String[]{"p", "q", "r", "s"};
            case '8':
                return new String[]{"t", "u", "v"};
            case '9':
                return new String[]{"w", "x", "y", "z"};
            default:
                return new String[]{""};
        }
    }

}
