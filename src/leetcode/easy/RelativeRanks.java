package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }

    public static String[] findRelativeRanks(int[] score) {
        int[] sort = Arrays.copyOf(score, score.length);
        Arrays.sort(sort);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < sort.length; i++) {
            map.put(sort[i], sort.length - i);
        }

        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            if (map.get(score[i]) <= 3) {
                switch (map.get(score[i])) {
                    case 1 -> res[i] = "Gold Medal";
                    case 2 -> res[i] = "Silver Medal";
                    case 3 -> res[i] = "Bronze Medal";
                }

            } else {
                res[i] = map.get(score[i]).toString();
            }
        }
        return res;
    }

    public static String[] findRelativeRanks_best(int[] nums) {
        String[] result = new String[nums.length];
        int max = 0;
        for (int i : nums) {
            if (i > max)
                max = i;
        }
        int[] hash = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] = i + 1;
        }
        int place = 1;
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0) {
                if (place == 1) {
                    result[hash[i] - 1] = "Gold Medal";
                } else if (place == 2) {
                    result[hash[i] - 1] = "Silver Medal";
                } else if (place == 3) {
                    result[hash[i] - 1] = "Bronze Medal";
                } else {
                    result[hash[i] - 1] = String.valueOf(place);
                }
                place++;
            }
        }
        return result;
    }
}
