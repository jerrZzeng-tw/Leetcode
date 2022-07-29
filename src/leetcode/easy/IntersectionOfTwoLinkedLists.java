package leetcode.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        node4.next = node5;
        ListNode node8 = new ListNode(8);
        node8.next = node4;
        ListNode node1_A = new ListNode(1);
        node1_A.next = node8;
        ListNode node4_A = new ListNode(4);
        node4_A.next = node1_A;
        ListNode node1_B = new ListNode(1);
        node1_B.next = node8;
        ListNode node6_B = new ListNode(6);
        node6_B.next = node1_B;
        ListNode node5_B = new ListNode(5);
        node5_B.next = node6_B;

        ListNode result = getIntersectionNode_stock(node4_A, node5_B);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    /**
     * 使用stack
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode_stock(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointA != null || pointB != null) {
            if (pointA != null) {
                stackA.push(pointA);
                pointA = pointA.next;
            }
            if (pointB != null) {
                stackB.push(pointB);
                pointB = pointB.next;
            }
        }
        ListNode lastEqual = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            pointA = stackA.pop();
            pointB = stackB.pop();
            if (pointA.equals(pointB)) {
                lastEqual = pointA;
            } else {
                return lastEqual;
            }
        }
        return lastEqual;
    }

    /**
     * 使用set
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode_set(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode point;
        ListNode point_b;
        while (headA != null) {
            point = headA;
            point_b = headB;
            while (point_b != null) {
                if (point.equals(point_b)) {
                    return point;
                }
                point_b = point_b.next;
            }
            headA = headA.next;
        }
        return null;
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
