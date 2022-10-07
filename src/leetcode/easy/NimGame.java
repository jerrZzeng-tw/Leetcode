package leetcode.easy;

public class NimGame {
    public static void main(String[] args) {
        System.out.println(canWinNim(7));
    }

    public static boolean canWinNim(int n) {
        return !((n % 4) == 0);
    }
}
