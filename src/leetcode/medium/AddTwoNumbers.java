package leetcode.medium;

import leetcode.dataStructure.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = ListNode.getNode(new int[]{5});
        ListNode l2 = ListNode.getNode(new int[]{6});
        ListNode.printAll(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, false);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean carry) {
        if (l1 == null && l2 == null) {
            if (carry) {
                return new ListNode(1);
            } else {
                return null;
            }
        }
        int n1 = l1 == null ? 0 : l1.val;
        int n2 = l2 == null ? 0 : l2.val;
        int sum = carry ? (n1 + n2 + 1) : (n1 + n2);
        ListNode node = new ListNode(sum % 10);
        node.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum >= 10);
        return node;
    }
}
