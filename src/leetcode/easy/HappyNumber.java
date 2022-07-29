package leetcode.easy;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy_best(int n) {
        if ((n == 1) || (n == 7)) {
            return true;
        } else if (n < 10) {
            return false;
        }
        int m = 0;
        while (n != 0) {
            int tail = n % 10;
            m += tail * tail;
            n /= 10;
        }
        return isHappy(m);
    }

    public static boolean isHappy(int n) {
        if ((n == 1) || (n == 7)) {
            return true;
        } else if (n < 10) {
            return false;
        }
        String ns = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < ns.length(); i++) {
            int point = Integer.parseInt(Character.toString(ns.charAt(i)));
            sum += (point * point);
        }
        return isHappy(sum);
    }


}
