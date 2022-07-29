package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindandReplacePattern {

    public static void main(String[] args) {
        findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb").forEach(
                System.out::println);
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (find(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    public static boolean find(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        if (word.length() != pattern.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (map.get(pattern.charAt(i)) != word.charAt(i)) {
                    return false;
                }
            } else {
                if (!set.add(word.charAt(i))) {
                    return false;
                }
                map.put(pattern.charAt(i), word.charAt(i));
            }
        }
        return true;
    }

    public static boolean find_best(String word, String pattern) {
        for (int i = 0; i < word.length(); i++) {
            if (word.indexOf(word.charAt(i)) != pattern.indexOf(pattern.charAt(i)))
                return false;
        }
        return true;
    }
}
