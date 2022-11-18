package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedINArray {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] array = new int[nums.length + 1];
        for (int num : nums) {
            array[num]++;
        }

        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
