package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class summaryRanges {

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{-2147483648, -2147483647, 2147483647}));
    }

    public static List<String> summaryRanges_best(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (sb.length() == 0) {
                sb.append(nums[i]);
            }
            if (i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {
                res.add(new String(sb.toString()));
                sb = new StringBuilder();
                continue;
            } else {
                sb.append('-');
                sb.append('>');
            }
            while (i < nums.length - 1 && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            sb.append(nums[i]);
            res.add(new String(sb.toString()));
            sb = new StringBuilder();
        }
        return res;
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        Integer s = null;
        Integer e = null;
        for (int i = 0; i < nums.length; i++) {
            if (s == null) {
                s = nums[i];
                e = nums[i];
                continue;
            } else {
                if (e == nums[i] - 1) {
                    e++;
                    continue;
                } else {
                    if (s.intValue() == e.intValue()) {
                        ranges.add(s.toString());
                    } else {
                        ranges.add(s + "->" + e);
                    }
                    s = nums[i];
                    e = nums[i];
                }
            }

        }

        if (s != null) {
            if (s.intValue() == e.intValue()) {
                ranges.add(s.toString());
            } else {
                ranges.add(s + "->" + e);
            }
        }
        return ranges;
    }
}
