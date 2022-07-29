package leetcode.easy;

public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabb"));
    }

    public static int firstUniqChar(String s) {
        // a to z Uniq index ( >0: appear index,-1:none appear, -2: more than once)
        int[] ar = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1};
        char[] s_ar = s.toCharArray();
        for (int i = 0; i < s_ar.length; i++) {
            int index = ar[s_ar[i] - 'a'];
            if (index == -1) {
                // first appear index
                ar[s_ar[i] - 'a'] = i;
            } else if (index >= 0) {
                // appear more than once
                ar[s_ar[i] - 'a'] = -2;
            }
        }

        for (char val : s_ar) {
            if (ar[val - 'a'] >= 0) {
                return ar[val - 'a'];
            }
        }

        return -1;
    }

    public static int firstUniqChar_best(String s) {
        int ans = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int res = s.indexOf(c);
            if (res != -1 && res == s.lastIndexOf(c))
                ans = Math.min(ans, res);
        }
        return ans == s.length() ? -1 : ans;
    }

}
