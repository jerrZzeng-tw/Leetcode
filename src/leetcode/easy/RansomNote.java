package leetcode.easy;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];
        for (char c : magazine.toCharArray()) {
            array[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (array[c - 'a']-- <= 0) {
                return false;
            }
        }
        return true;
    }
}
