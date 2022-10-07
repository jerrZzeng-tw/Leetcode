package leetcode.easy;

public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        while (num >= 10) {
            num = addDigits(String.valueOf(num));
        }
        return num;
    }

    public static int addDigits(String num) {
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum += (Integer.valueOf(num.charAt(i)) - 48);
        }
        return sum;
    }


    public int addDigits_math(int num) {
        if (num == 0)
            return 0;
        else if (num % 9 == 0)
            return 9;
        else
            return num % 9;
    }
}
