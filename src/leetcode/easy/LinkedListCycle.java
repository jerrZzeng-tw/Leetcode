package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);

        ListNode n2 = new ListNode(2);
        ListNode n0 = new ListNode(0);
        ListNode n_4 = new ListNode(-4);
        ListNode n1 = new ListNode(1);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n0;
        n0.next = n_4;
        n_4.next = n1;
        n1.next = n5;
        n5.next = n2;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle_best(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("slow:" + slow.val + " fast:" + fast.val);
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
