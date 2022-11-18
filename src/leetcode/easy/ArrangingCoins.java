package leetcode.easy;

public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins_best(5));
    }

    public static int arrangeCoins(int n) {
        long sum = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            sum += i;
            if (sum > n) {
                return i - 1;
            }
        }
        return 0;
    }

    public static int arrangeCoins_best(int n) {
        long low = 1, hight = n;
        long ans = 0;
        while (low <= hight) {
            long gusse = (hight + low) / 2;
            if (count(gusse) > n) {
                hight = gusse - 1;
            } else {
                ans = gusse;
                low = gusse + 1;
            }
        }
        return (int) ans;
    }

    public static long count(long n) {
        return n * (n + 1) / 2;
    }
}
