package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int threshold = (nums.length / 2) + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            int count = map.containsKey(num) ? map.get(num) + 1 : 1;
            if (count >= threshold) {
                return num;
            } else {
                map.put(num, count);
            }
        }
        return nums[0];
    }
}
