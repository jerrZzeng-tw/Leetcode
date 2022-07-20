package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) throws Exception {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stak = new Stack<>();
        Set<Character> push = new HashSet<>();
        push.add('{');
        push.add('[');
        push.add('(');
        Map<Character,Character> pop = new HashMap<>();
        pop.put('}','{');
        pop.put(']','[');
        pop.put(')','(');

        for(int i=0;i<s.length();i++){
            Character c =  s.charAt(i);
            if(push.contains(c)){
                stak.push(c);
            }else{
                if(stak.isEmpty() || stak.pop()!=pop.get(c)){
                    return false;
                }
            }
        }

        return stak.isEmpty();
    }
}
