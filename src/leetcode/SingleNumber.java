package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 4, 3, 1, 2}));
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else if (!(set.contains(nums[i]))) {
                set.add(nums[i]);
            }
        }
        return (int) set.toArray()[0];
    }

    public static int singleNumber_best(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            res ^= nums[i];
        }
        return res;
    }
}
