package leetcode.medium;

import java.util.Arrays;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        char[] ca = s.toCharArray();
        int[] count = new int[ca.length];
        Arrays.fill(count, -1);
        return numDecodings(ca, 0, count);
    }
    
    public static int numDecodings(char[] ca, int index, int[] count) {
        if (index == ca.length - 1 && ca[index] == '0') {
            return 0;
        }
        if (index >= ca.length - 1) {
            return 1;
        }

        if (count[index] != -1) {
            return count[index];
        }

        int res = 0;
        if (ca[index] != '0') {
            res = numDecodings(ca, index + 1, count);
            if (ca[index] == '1' || (ca[index] == '2' && ca[index + 1] <= '6')) {
                res = res + numDecodings(ca, index + 2, count);
            }
        }
        count[index] = res;
        return res;
    }

}
