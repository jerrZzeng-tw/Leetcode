package leetcode.easy;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the mooan  "));
    }

    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (length == 0 && s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == ' ') {
                return length;
            }
            length++;
        }

        return length;
    }
}
