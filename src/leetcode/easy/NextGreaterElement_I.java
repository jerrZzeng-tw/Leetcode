package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement_I {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = NextGreater(nums2, nums1[i], map.get(nums1[i]));
        }
        return res;
    }

    public static int NextGreater(int[] nums2, int target, int start) {
        for (int i = start; i < nums2.length; i++) {
            if (nums2[i] > target) {
                return nums2[i];
            }
        }

        return -1;
    }
}
