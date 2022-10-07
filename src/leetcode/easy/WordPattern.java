package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (ss.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (map.containsValue(ss[i])) {
                    return false;
                }
                map.put(c, ss[i]);
            } else {
                if (!map.get(c).equals(ss[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
