package leetcode.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome_best(1221));
    }

    public static boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        for (int i = 0; i < (str.length() / 2); i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }

    public static boolean isPalindrome_best(int x) {
        int n = x, sum = 0;
        boolean result = false;

        while (n > 0) {
            int r = n % 10;
            sum = sum * 10 + r;
            n = n / 10;
        }
        if (x == sum) {
            result = true;

        }
        return result;
    }
}
