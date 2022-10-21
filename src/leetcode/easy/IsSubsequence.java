package leetcode.easy;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int pos = -1;
        char[] arr_t = t.toCharArray();
        for (char c : s.toCharArray()) {
            pos = findPosition(arr_t, pos + 1, c);
            if (pos == -1) {
                return false;
            }
        }
        return true;
    }

    public static int findPosition(char[] chars, int start, char target) {
        for (int i = start; i < chars.length; i++) {
            if (target == chars[i])
                return i;
        }
        return -1;
    }
}
