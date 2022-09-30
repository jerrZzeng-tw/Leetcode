package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic_best("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (t.charAt(i) != map.get(s.charAt(i))) {
                    return false;
                }
            } else {
                if (set.contains(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }

    public static boolean isIsomorphic_best(String s, String t) {
        return pattern(s).equals(pattern(t));
    }

    public static String pattern(String s) {
        int[] sv = new int[128];
        int si = 1;
        StringBuilder sb = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
            if (sv[ch] == 0)
                sv[ch] = si++;
            sb.append((char) sv[ch]);
        }
        return sb.toString();
    }
}
