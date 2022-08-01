package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_Map("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        StringBuffer sb = new StringBuffer();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = sb.indexOf(String.valueOf(c));
            if (index >= 0) {
                max = Math.max(max, sb.length());
                sb.delete(0, index + 1);
            }
            sb.append(c);
        }
        max = Math.max(max, sb.length());
        return max;
    }

    public static int lengthOfLongestSubstring_Map(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxString = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                maxString = Math.max(maxString, i - start + 1);
            } else {
                start = Math.max(map.get(s.charAt(i)) + 1, start);
                map.put(s.charAt(i), i);
                maxString = Math.max(maxString, i - start + 1);
            }
        }
        return maxString;
    }
}


