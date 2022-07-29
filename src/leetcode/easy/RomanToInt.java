package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) throws Exception {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int number = 0;
        int last = 0;
        return caculate(0, s, map);
    }

    public static int caculate(int number, String subStr, Map<Character, Integer> map) {
        if (subStr.length() == 0) {
            return number;
        }
        int next = map.get(subStr.charAt(0));
        if (number >= next) {
            return number + caculate(next, subStr.substring(1), map);
        } else {
            return -number + caculate(next, subStr.substring(1), map);
        }
    }
}
