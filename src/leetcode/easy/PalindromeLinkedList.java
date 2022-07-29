package leetcode.easy;

import leetcode.dataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;


public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(isPalindrome_recursively(node1));
        System.out.println(isPalindrome(node1));

    }

    public static boolean isPalindrome_recursively(ListNode head) {
        Set<Boolean> isPalindrome = new HashSet<>();
        isPalindrome_recursively(head, head, isPalindrome);
        return !isPalindrome.contains(false);
    }

    public static ListNode isPalindrome_recursively(ListNode node, ListNode head, Set<Boolean> isPalindrome) {
        if (node == null) {
            return head;
        }

        ListNode res = isPalindrome_recursively(node.next, head, isPalindrome);
        if (node.val != res.val) {
            isPalindrome.add(false);
        }
        //        System.out.println(node.val + "," + res.val);
        return res.next;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode hi = ListNode.reverse(slow);
        ListNode lo = head;
        while (hi.next != null) {
            if (lo.val != hi.val)
                return false;
            lo = lo.next;
            hi = hi.next;
        }
        return true;
    }


}
