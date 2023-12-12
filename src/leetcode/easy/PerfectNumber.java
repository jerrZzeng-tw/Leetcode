package leetcode.easy;

public class PerfectNumber {

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(29));
    }

    public static boolean checkPerfectNumber(int num) {
        int num1 = num;
        for (int i = 2; i * i <= num; i++) {
            if (num1 <= 0) {
                break;
            }
            if ((num % i) == 0) {
                int a = num / i;
                num1 -= i;
                num1 -= a;
            }
        }

        return (num1 == 1);

    }
}
