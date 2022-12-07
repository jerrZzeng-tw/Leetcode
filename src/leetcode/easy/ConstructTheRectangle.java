package leetcode.easy;

import java.util.Arrays;

public class ConstructTheRectangle {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle(122122)));
    }

    public static int[] constructRectangle(int area) {
        int[] result = new int[]{area, 1};
        if (area == 2) {
            return result;
        }
        for (int w = (int) Math.sqrt(area); w > 0; w--) {
            if (area % w == 0) {
                int l = (area / w);
                if ((result[0] - result[1]) > (l - w)) {
                    result[0] = l;
                    result[1] = w;
                }
            }
        }
        return result;
    }
}
