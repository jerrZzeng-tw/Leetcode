package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(t -> {
            t.forEach(System.out::print);
            System.out.println("");
        });
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            System.out.println(key.getBytes());
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static String getKey(String str) {
        char[] letters = new char[26];
        for (int i = 0; i < str.length(); i++) {
            letters[str.charAt(i) - 'a']++;
        }
        return new String(letters);
    }
}
