package leetcode.medium;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int left, int right) {
        if (left >= right) {
            if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        // right sorted
        if (nums[middle] < nums[right]) {
            if (nums[middle] <= target && target <= nums[right]) {
                return search(nums, target, middle + 1, right);
            } else {
                return search(nums, target, left, middle - 1);
            }
        }
        // left sorted
        else {
            if (nums[left] <= target && target <= nums[middle]) {
                return search(nums, target, left, middle - 1);
            } else {
                return search(nums, target, middle + 1, right);
            }
        }
    }
}