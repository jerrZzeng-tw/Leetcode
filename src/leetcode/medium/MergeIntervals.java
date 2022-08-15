package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        Arrays.stream(merge(new int[][]{{1, 4}, {2, 3}})).forEach(t -> {
            System.out.println(t[0] + "," + t[1]);
        });
    }

    public static int[][] merge(int[][] intervals) {
        //        quickSort(intervals, 0, intervals.length - 1);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int s = intervals[0][0];
        int e = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (s <= intervals[i][0] && intervals[i][0] <= e) {
                e = Math.max(e, intervals[i][1]);
            } else {
                res.add(new int[]{s, e});
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }
        res.add(new int[]{s, e});
        return res.toArray(new int[res.size()][2]);
    }

    public static void quickSort(int[][] nums, int left, int right) {
        if (right <= left)
            return;
        // middle pivot
        int pivotIndex = (left + right) / 2;
        int pivot[] = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int swapIndex = left;
        for (int i = left; i < right; ++i) {
            if (nums[i][0] < pivot[0]) {
                swap(nums, i, swapIndex);
                ++swapIndex;
            } else if (nums[i][0] == pivot[0] && nums[i][1] < pivot[1]) {
                swap(nums, i, swapIndex);
                ++swapIndex;
            }
        }
        swap(nums, swapIndex, right);

        quickSort(nums, left, swapIndex - 1);
        quickSort(nums, swapIndex + 1, right);

    }

    public static void swap(int[][] number, int i, int j) {
        int[] t = number[i];
        number[i] = number[j];
        number[j] = t;
    }
}
