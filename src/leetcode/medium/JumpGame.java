package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public static boolean canJump(int[] nums) {
        //        return canJump(nums, nums.length - 1, new HashSet<>());
        return canJump_best(nums);
    }


    public static boolean canJump_best(int[] nums) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (i > max)
                return false;
            if (max > length)
                return true;
            max = Math.max(max, nums[i] + i);
        }

        return true;
    }

    public static boolean canJump(int[] nums, int end, Set<Integer> set) {
        if (end < 0) {
            return false;
        }
        if (nums[0] >= end) {
            return true;
        }

        List<Integer> preList = new ArrayList<>();
        // find all pre step
        for (int i = 0; i < end; i++) {
            int distance = end - i;
            if (nums[i] >= distance) {
                if (!set.contains(i)) {
                    preList.add(i);
                }
            }
        }
        // check pre step
        for (Integer pre : preList) {
            if (canJump(nums, pre, set)) {
                return true;
            } else {
                set.add(pre);
            }
        }
        return false;
    }
}
