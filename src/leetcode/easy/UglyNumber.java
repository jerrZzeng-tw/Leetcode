package leetcode.easy;

public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(isUgly(0));
    }

    public static boolean isUgly(int n) {
        if (n == 0)
            return false;
        return (remove_5(remove_3(remove_2(n))) == 1);
    }

    public static int remove_2(int n) {
        while (n % 2 == 0)
            n /= 2;
        return n;
    }

    public static int remove_3(int n) {
        while (n % 3 == 0)
            n /= 3;
        return n;
    }

    public static int remove_5(int n) {
        while (n % 5 == 0)
            n /= 5;
        return n;
    }
}
