package leetcode.medium;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = curr + nums[i];
            if (curr < 0 || curr < nums[i]) {
                curr = nums[i];
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
