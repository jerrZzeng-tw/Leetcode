package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class MyStack {
    List<Integer> list;

    public MyStack() {
        list = new LinkedList<Integer>();
    }

    public void push(int x) {
        list.add(0, x);
    }

    public int pop() {
        int temp = list.get(0);
        list.remove(0);
        return temp;
    }

    public int top() {
        return list.get(0);
    }

    public boolean empty() {
        return list.isEmpty();
    }
}
