package leetcode.medium;

import leetcode.dataStructure.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = ListNode.getNode(new int[]{1, 2, 3, 4});
        ListNode res = swapPairs(head);
        ListNode.printAll(res);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        ListNode next;
        while (cur != null && cur.next != null) {
            next = cur.next;
            cur.next = cur.next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
