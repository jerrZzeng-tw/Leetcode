package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3}).forEach(t -> {
            t.forEach(s -> {
                System.out.print(s + ",");
            });
            System.out.println();
        });

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //        permutations_recursively(nums, 0, res);
        permutations(new int[]{}, nums, res);
        return res;
    }

    public static void permutations(int[] front, int[] remain, List<List<Integer>> res) {
        if (remain.length == 0) {
            List<Integer> data = new ArrayList<>(front.length);
            for (int num : front) {
                data.add(num);
            }
            res.add(data);
        }
        for (int i = 0; i < remain.length; i++) {
            int[] newfront = Arrays.copyOf(front, front.length + 1);
            newfront[front.length] = remain[i];
            int[] newRemain = new int[remain.length - 1];
            System.arraycopy(remain, 0, newRemain, 0, i);
            System.arraycopy(remain, i + 1, newRemain, i, remain.length - i - 1);
            //            System.out.print(Arrays.toString(newfront));
            //            System.out.println(Arrays.toString(newRemain));
            permutations(newfront, newRemain, res);
        }
    }

    public static void permutations_recursively(int[] nums, int currentIndex, List<List<Integer>> res) {
        if (currentIndex == nums.length - 1) {
            List<Integer> data = new ArrayList<>(nums.length);
            for (int num : nums) {
                data.add(num);
            }
            res.add(data);
        }

        for (int i = currentIndex; i < nums.length; i++) {
            swap(nums, currentIndex, i);
            permutations_recursively(nums, currentIndex + 1, res);
            swap(nums, currentIndex, i);
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
