package leetcode;

import java.util.LinkedList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 50, 75};
        findMissingRanges(nums, 0, 99).forEach(t -> System.out.println(t));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<String>();
        if (nums.length == 0) {
            findRange(result, lower, upper);
            return result;
        }
        if (nums[0] != Integer.MIN_VALUE) {
            findRange(result, lower, nums[0] - 1);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            findRange(result, nums[i] + 1, nums[i + 1] - 1);
        }
        if (nums[nums.length - 1] != Integer.MAX_VALUE) {
            findRange(result, nums[nums.length - 1] + 1, upper);
        }

        return result;
    }

    private static void findRange(List<String> result, int low, int up) {
        if (low > up) {
            return;
        }
        if (low == up) {
            result.add((low) + "");
            return;
        }
        result.add(low + "->" + up);
    }
}
