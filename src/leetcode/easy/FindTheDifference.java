package leetcode.easy;

public class FindTheDifference {

    public static void main(String[] args) {
        System.out.println(findTheDifference_sum("a", "aa"));
    }

    public static char findTheDifference(String s, String t) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (array[c - 'a']-- <= 0) {
                return c;
            }
        }
        return ' ';
    }

    public static char findTheDifference_sum(String s, String t) {
        int sum_s = 0;
        int sum_t = 0;
        for (char c : s.toCharArray()) {
            sum_s += c;
        }
        for (char c : t.toCharArray()) {
            sum_t += c;
        }
        return (char) (sum_t - sum_s);
    }
}
