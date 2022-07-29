package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays_II {

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 5, 5, 8, 9};
        int[] nums2 = new int[]{4, 5, 6, 7, 9, 10};
        int[] num = intersect_map(nums1, nums2);
        Arrays.stream(num).forEach(System.out::println);
    }

    public static int[] intersect_sort(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static int[] intersect_array(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        List<Integer> res = new ArrayList<>();
        for (int val : nums1) {
            arr[val] = arr[val] + 1;
        }

        for (int val : nums2) {
            arr[val] = arr[val] - 1;
            if (arr[val] >= 0) {
                res.add(val);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static int[] intersect_map(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] shorter = nums1;
        int[] longer = nums2;
        if (nums1.length > nums2.length) {
            shorter = nums2;
            longer = nums1;
        }
        List<Integer> res = new ArrayList<>();
        for (int val : shorter) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (int val : longer) {
            int count = map.getOrDefault(val, 0);
            if (count > 0) {
                res.add(val);
                map.put(val, count - 1);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }


}
