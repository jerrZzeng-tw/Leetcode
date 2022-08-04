package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {
    public static void main(String[] args) {
        generateParenthesis_best(4).forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        } else {
            return new LinkedList<String>(generate(n));
        }
    }

    public static Set<String> generate(int n) {
        if (n == 2) {
            Set<String> set = new HashSet<>();
            set.add("()()");
            set.add("(())");
            return set;
        }
        Set<String> pre = generate(n - 1);
        Set<String> set = new HashSet<>();
        for (String val : pre) {
            for (int i = 0; i < val.length(); i++) {
                set.add(val.substring(0, i) + "()" + val.substring(i));
            }
        }
        return set;
    }

    public static List<String> generateParenthesis_best(int n) {
        List<String> ans = new ArrayList<>();

        solve(ans, new StringBuilder(""), n, n);

        return ans;
    }

    public static void solve(List<String> ans, StringBuilder sb, int ob, int cb) {
        if (ob == 0 && cb == 0) {
            ans.add(sb.toString());
            return;
        }
        if (ob > 0) {
            sb.append('(');
            solve(ans, sb, ob - 1, cb);
            System.out.println(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
        }
        if (cb > 0) {
            if (ob < cb) {
                sb.append(')');
                solve(ans, sb, ob, cb - 1);
                System.out.println(sb.toString());
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
