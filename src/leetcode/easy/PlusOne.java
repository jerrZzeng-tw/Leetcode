package leetcode.easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) throws Exception {
        int[] digits = new int[]{1, 1, 9};
        int[] result = plusOne(digits);
        Arrays.stream(result).forEach(System.out::print);
    }

    public static int[] plusOne(int[] digits) {
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + plus;
            digits[i] = sum % 10;
            plus = sum / 10;
            if (plus == 0) {
                return digits;
            }
        }

        if (plus > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = plus;
            return newDigits;
        }
        return digits;
    }

    public static int[] plusOne_2(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

}
