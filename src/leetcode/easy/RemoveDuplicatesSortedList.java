package leetcode.easy;

import leetcode.dataStructure.ListNode;

public class RemoveDuplicatesSortedList {

    public static void main(String[] args) {
        ListNode.printAll(deleteDuplicates(ListNode.getNode(new int[]{1, 1, 2, 3, 3})));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode index = head;
        while (index != null) {
            if (index.next != null && index.val == index.next.val) {
                index.next = index.next.next;
            } else {
                index = index.next;
            }
        }
        return head;
    }
}
