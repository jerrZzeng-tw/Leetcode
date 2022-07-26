package leetcode;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o', 'w'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        int middle = s.length / 2;
        char temp;
        for (int i = 0; i < middle; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
