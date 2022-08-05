package leetcode.medium;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 0, 4, 3, 1};
        nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void nextPermutation(int[] nums) {

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        quickSort(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
                return;
            }
        }
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (right <= left)
            return;
        // middle pivot
        int pivotIndex = (left + right) / 2;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int swapIndex = left;
        for (int i = left; i < right; ++i) {
            if (nums[i] <= pivot) {
                swap(nums, i, swapIndex);
                ++swapIndex;
            }
        }
        swap(nums, swapIndex, right);

        quickSort(nums, left, swapIndex - 1);
        quickSort(nums, swapIndex + 1, right);

    }

    public static void swap(int[] number, int i, int j) {
        int t = number[i];
        number[i] = number[j];
        number[j] = t;
    }

}
