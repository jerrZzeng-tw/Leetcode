package leetcode.easy;

import leetcode.dataStructure.TreeNode;

public class SameTree {

    public static void main(String[] args) {
        System.out.println(
                isSameTree(TreeNode.getTree(new Integer[]{1, null, 3}), TreeNode.getTree(new Integer[]{1, null, 3})));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (!isEqual(p, q)) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isEqual(TreeNode p1, TreeNode q1) {
        int a = p1 == null ? -1 : p1.val;
        int b = q1 == null ? -1 : q1.val;
        return a == b;
    }
}
