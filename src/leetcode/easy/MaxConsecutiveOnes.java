package leetcode.easy;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes_1(new int[]{1, 1, 1, 0, 1, 1, 0}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int index = -1;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (index == -1) {
                    length = Math.max(length, i);
                } else {
                    length = Math.max(length, i - index - 1);
                }
                index = i;
            }
        }
        length = Math.max(length, nums.length - index - 1);
        return length;
    }

    public static int findMaxConsecutiveOnes_1(int[] nums) {
        int length = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                length++;
            } else {
                max = Math.max(length, max);
                length = 0;
            }
        }
        return Math.max(length, max);
    }

}
