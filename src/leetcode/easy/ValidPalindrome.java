package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                list.add(Character.toUpperCase(s.charAt(i)));
            }
        }
        if (list.size() == 0) {
            return true;
        }
        int size = list.size() - 1;
        int middle = size / 2;
        for (int i = 0; i <= middle; i++) {
            if (!list.get(i).equals(list.get(size - i))) {
                return false;
            }
        }
        return true;
    }
}
