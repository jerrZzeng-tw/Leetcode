package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("ababab"));
    }

    //從一半的字數開始檢查. 並且只檢查可以整除的. 由字串大->小檢查速度比較快
    public static boolean repeatedSubstringPattern_best(String s) {
        int l = s.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                if (s.charAt(i - 1) != s.charAt(l - 1))
                    continue;
                String sub = s.substring(0, i);
                int m = l / i, p = 1;
                while (p < m && sub.equals(s.substring(i * p, i * p + i)))
                    p++;
                if (p == m)
                    return true;
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len == 1) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int gcd = dogcd(map.values().toArray(new Integer[0]));
        if (gcd == 1) {
            return false;
        }
        int base = len / gcd;
        for (int i = len - base; i > 0; i -= base) {
            if ((len % i) == 0 && check(s, i)) {
                return true;
            }
        }

        return false;
    }

    public static boolean check(String s, int size) {
        String subStr = s.substring(0, size);
        for (int i = 0; i < s.length() / size; i++) {
            if (!s.startsWith(subStr, i * size)) {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int m, int n) {
        int result = 1;
        while (m % n != 0) {
            result = n;
            n = m % n;
            m = result;
        }
        result = n;
        return result;
    }

    public static int dogcd(Integer[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            input[i + 1] = gcd(input[i], input[i + 1]);
        }
        return input[input.length - 1];

    }
}
