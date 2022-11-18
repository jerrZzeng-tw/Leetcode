package leetcode.easy;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{3, 2, 1}));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index_s = 0;
        int result = 0;
        for (int child : g) {
            for (int j = index_s; j < s.length; j++) {
                if (s[j] >= child) {
                    result++;
                    index_s = j + 1;
                    break;
                }
            }
            if (index_s >= s.length) {
                return result;
            }
        }
        return result;
    }

    public int findContentChildren_while(int[] g, int[] s) {
        int i = 0, j = 0, sum = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                sum++;
            } else {
                j++;
            }
        }
        return sum;
    }
}
