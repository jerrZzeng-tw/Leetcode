package leetcode.medium;

import leetcode.dataStructure.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(isValidBST(TreeNode.getTree(new Integer[]{3, 1, 5, 0, 2, 4, 6, null, null, null, 3})));
    }

    public static boolean isValidBST(TreeNode root) {
        return checkNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean checkNode(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return checkNode(node.left, min, node.val) && checkNode(node.right, node.val, max);
    }

    public static boolean checkNode_1(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.right != null && (node.val >= node.right.val || max <= node.right.val)) {
            return false;
        }
        if (node.left != null && (node.val <= node.left.val || min >= node.left.val)) {
            return false;
        }
        return checkNode(node.left, min, node.val) && checkNode(node.right, node.val, max);
    }


}
