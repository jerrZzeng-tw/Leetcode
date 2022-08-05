package leetcode.medium;

import java.util.Arrays;

public class FindFirstLastPositionElementInSortedArray {
    public static void main(String[] args) {
        Arrays.stream(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10)).forEach(System.out::println);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length > 0) {
            searchRange(nums, target, 0, nums.length - 1, res);
        }
        return res;
    }

    public static void searchRange(int[] nums, int target, int left, int right, int[] res) {
        if (left >= right) {
            if (nums[left] == target) {
                if (res[0] == -1 || left < res[0]) {
                    res[0] = left;
                }
                if (res[1] == -1 || left > res[1]) {
                    res[1] = left;
                }
            }
            return;
        }

        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            searchRange(nums, target, left, middle, res);
            searchRange(nums, target, middle + 1, right, res);
        } else if (nums[middle] > target) {
            searchRange(nums, target, left, middle - 1, res);
        } else {
            searchRange(nums, target, middle + 1, right, res);
        }
    }
}
