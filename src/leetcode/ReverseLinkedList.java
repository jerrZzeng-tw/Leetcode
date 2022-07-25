package leetcode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        node4.next = node5;
        ListNode node3 = new ListNode(3);
        node3.next = node4;
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;


        ListNode result = reverseList_recursively(node1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode reverseList_recursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = reverseList_recursively(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }


    public static ListNode reverseList_iteratively(ListNode head) {
        ListNode pre = null, now = null;
        while (head != null) {
            now = head;
            head = head.next;
            now.next = pre;
            pre = now;
        }
        return now;
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
