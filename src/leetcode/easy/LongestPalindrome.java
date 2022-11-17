package leetcode.easy;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcCccdd"));
    }

    public static int longestPalindrome(String s) {
        int[] ar = new int[57];
        for (int i = 0; i < s.length(); i++) {
            ar[s.charAt(i) - 'A']++;
        }

        boolean add = false;
        int length = 0;
        for (int i = 0; i < ar.length; i++) {
            if (!add && (ar[i] % 2 == 1)) {
                add = true;
            }
            length = length + ar[i] / 2;
        }
        return add ? length * 2 + 1 : length * 2;
    }
}
