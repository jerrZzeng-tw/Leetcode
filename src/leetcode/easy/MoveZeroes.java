package leetcode.easy;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0};
        moveZeroes(nums);
        System.out.println(nums);
    }

    public static void moveZeroes(int[] nums) {
        int shift = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                shift++;
            } else if (shift > 0) {
                nums[i - shift] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public static void moveZeroes_best(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }

        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
