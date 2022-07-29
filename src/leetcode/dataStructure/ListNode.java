package leetcode.dataStructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode getNode(int[] nums) {
        ListNode root = new ListNode(0);
        ListNode pre = root;
        for (int val : nums) {
            pre.next = new ListNode(val);
            pre = pre.next;
        }
        return root.next;
    }

    public static void printAll(ListNode root) {
        ListNode node = root;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
