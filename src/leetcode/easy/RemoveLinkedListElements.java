package leetcode.easy;

import leetcode.dataStructure.ListNode;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        System.out.println(removeElements(ListNode.getNode(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dome = new ListNode(0);
        dome.next = head;
        ListNode temp = dome;
        while (temp.next != null) {

            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dome.next;
    }
}
