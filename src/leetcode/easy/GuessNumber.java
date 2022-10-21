package leetcode.easy;

public class GuessNumber {
    public static int tar = 2147483647;

    public static void main(String[] args) {
        long low = 1;
        long hight = Integer.MAX_VALUE;
        System.out.println(((2147483647L + 2147483648L) / 2) + 1);
        System.out.println(((2147483647L + 2147483647L) / 2) + 1);

        while ((hight - low) > 1) {
            long num = (low + hight) / 2;
            switch (guess((int) num)) {
                case -1: {
                    hight = num;
                    break;
                }
                case 1: {
                    low = num;
                    break;
                }
                default: {
                    System.out.println(num);
                    return;
                }
            }
        }

        if (guess((int) low) == 0) {
            System.out.println(low);
        } else {
            System.out.println(hight);
        }
    }

    static int guess(int num) {
        return Integer.compare(tar, num);
    }
}
