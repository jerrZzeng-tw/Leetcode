package leetcode.easy;

public class Sqrt {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + ":" + mySqrt(i));
        }
    }

    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int upper = x;
        int lower = 1;

        while ((upper - lower) > 1) {
            int middle = lower + ((upper - lower) / 2);
            int res = find(x, middle);
            switch (res) {
                case 1:
                    upper = middle;
                    break;
                case 0:
                    return middle;
                case -1:
                    lower = middle;
            }
        }
        return lower;
    }

    public static int find(int x, long middle) {
        long pox = middle * middle;
        if (pox > x) {
            return 1;
        } else if (pox == x) {
            return 0;
        } else {
            return -1;
        }
    }
}
