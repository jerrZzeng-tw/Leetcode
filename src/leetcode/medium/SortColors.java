package leetcode.medium;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 0, 1, 2, 1};
        sortColors_best(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void sortColors(int[] nums) {
        int[] count = new int[]{0, 0};
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    count[0] = count[0] + 1;
                    break;
                case 1:
                    count[1] = count[1] + 1;
                    break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i < count[0] + count[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void sortColors_best(int[] nums) {
        int left = 0, cur = 0, right = nums.length - 1;
        while (cur <= right) {
            if (nums[cur] == 2) {
                swap(nums, cur, right);
                right--;
            } else if (nums[cur] == 0) {
                swap(nums, cur, left);
                cur++;
                left++;
            } else {
                cur++;
            }
        }
    }

    public static void swap(int[] number, int i, int j) {
        int t = number[i];
        number[i] = number[j];
        number[j] = t;
    }
}
