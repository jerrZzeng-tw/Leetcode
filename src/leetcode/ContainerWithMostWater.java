package leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{3, 9, 3, 4, 7, 2, 12, 6}));
    }

    public static int maxArea(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int area = 0;
        while (left != right) {
            if (height[left] < height[right]) {
                area = Math.max(area, height[left] * (right - left));
                left++;
            } else {
                area = Math.max(area, height[right] * (right - left));
                right--;
            }
        }
        return area;
    }
}
