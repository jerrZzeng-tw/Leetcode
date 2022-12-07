package leetcode.easy;

public class TeemoAttacking {

    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int length = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            length += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        length += duration;
        return length;
    }

}
