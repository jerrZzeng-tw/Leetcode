package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        threeSum_twoPoint(new int[]{0, 0, 0, 0}).forEach(t -> {
            t.forEach(System.out::print);
            System.out.println();
        });
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            Set<Integer> set = new HashSet<>();
            Set<String> dup = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(nums[j]) && dup.add(String.valueOf(nums[i]) + (target - nums[j]) + nums[j])) {
                    list.add(Arrays.asList(nums[i], target - nums[j], nums[j]));
                }
                set.add(target - nums[j]);
            }
        }
        return list;
    }

    public static List<List<Integer>> threeSum_twoPoint(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int tar = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == tar) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > tar) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }


}
