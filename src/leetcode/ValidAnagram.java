package leetcode;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        Arrays.sort(a);
        char[] b = t.toCharArray();
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram_best(String s, String t) {
        int[] snum = new int[27];
        int[] tnum = new int[27];

        for (char c : s.toCharArray()) {
            snum[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tnum[c - 'a']++;
        }
        for (int i = 0; i < 27; i++) {
            if (snum[i] != tnum[i]) {
                return false;
            }
        }
        return true;
    }
}
