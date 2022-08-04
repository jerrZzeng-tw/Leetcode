package leetcode.medium;

import leetcode.dataStructure.ListNode;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = ListNode.getNode(new int[]{1});
        ListNode res = removeNthFromEnd(head, 1);
        ListNode.printAll(res);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // go to end node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
