package leetcode;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber_sum(new int[]{8, 6, 4, 2, 3, 5, 7, 9, 1}));
    }

    public static int missingNumber(int[] nums) {
        int max = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < max; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return max;
    }

    public static int missingNumber_sum(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
