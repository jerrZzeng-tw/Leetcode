package leetcode.easy;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
    }

    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            if (j > first) {
                third = second;
                second = first;
                first = j;
            } else if (j > second && j != first) {
                third = second;
                second = j;
            } else if (j > third && j != first && j != second) {
                third = j;
            }
        }

        if (third == Long.MIN_VALUE) {
            return (int) first;
        } else {
            return (int) third;
        }
    }
}
