package leetcode.easy;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert_recursively(nums, target, 0, nums.length - 1));
        System.out.println(searchInsert_iteratively(nums, target));
    }

    public static int searchInsert_iteratively(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    public static int searchInsert_recursively(int[] nums, int target, int min, int max) {
        int middle = (max - min) / 2 + min;
        if (min >= max) {
            return nums[middle] >= target ? min : max + 1;
        } else if (nums[middle] < target) {
            return searchInsert_recursively(nums, target, middle + 1, max);
        } else {
            return searchInsert_recursively(nums, target, min, middle - 1);
        }
    }
}
