package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths_best(3, 2));
    }

    public static int uniquePaths_best(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[j] = dp[j - 1] + dp[j];
        return dp[n - 1];
    }

    public static int uniquePaths(int m, int n) {
        return uniquePaths(m, n, new HashMap<String, Integer>());
    }

    public static int uniquePaths(int m, int n, Map<String, Integer> map) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int left = 0, upper = 0;
        String left_key = (m - 1) + "," + n, upper_key = m + "," + (n - 1);

        if (map.containsKey(left_key)) {
            left = map.get(left_key);
        } else {
            left = uniquePaths(m - 1, n, map);
            map.put(left_key, left);
        }

        if (map.containsKey(upper_key)) {
            upper = map.get(upper_key);
        } else {
            upper = uniquePaths(m, n - 1, map);
            map.put(upper_key, upper);
        }

        return left + upper;
    }

}
