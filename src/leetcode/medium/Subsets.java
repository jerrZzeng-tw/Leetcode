package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {
    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3}).forEach(t -> {
            t.forEach(s -> {
                System.out.print(s + ",");
            });
            System.out.println();
        });
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList());
        for (int i = 0; i < nums.length; i++) {
            int length = ret.size();
            for (int j = 0; j < length; j++) {
                List<Integer> currSet = new ArrayList(ret.get(j));
                currSet.add(nums[i]);
                ret.add(currSet);
            }
        }
        return ret;
    }

    public static List<List<Integer>> subsets_recursive(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        subsets_recursive(list, new int[]{}, nums);
        return list;
    }

    public static void subsets_recursive(List<List<Integer>> list, int[] front, int[] remain) {
        list.add(Arrays.stream(front).boxed().collect(Collectors.toList()));
        if (remain.length == 0) {
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            int[] newfront = Arrays.copyOf(front, front.length + 1);
            newfront[front.length] = remain[i];
            int[] newRemain = new int[remain.length - i - 1];
            System.arraycopy(remain, i + 1, newRemain, 0, remain.length - i - 1);
            subsets_recursive(list, newfront, newRemain);
        }
    }

}
