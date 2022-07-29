package leetcode.easy;

public class IsPowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree_log(27));
    }


    public static boolean isPowerOfThree(int n) {
        while (n > 1 && n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public static boolean isPowerOfThree_log(int n) {
        double rs = Math.log10(n) / Math.log10(3);
        return rs % 1 == 0;
    }

    public boolean isPowerOfThree_trick(int n) {
        if (n <= 0)
            return false;
        return 1162261467 % n == 0;
    }

    public static boolean isPowerOfThree_recursively(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }

        return isPowerOfThree(n / 3);
    }
}
