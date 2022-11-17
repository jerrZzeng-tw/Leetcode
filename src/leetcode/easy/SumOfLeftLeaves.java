package leetcode.easy;

import leetcode.dataStructure.TreeNode;

public class SumOfLeftLeaves {

    public static void main(String[] args) {
        System.out.println(sumOfLeftLeaves(TreeNode.getTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            TreeNode left = root.left;
            if (left != null && left.right == null && left.left == null) {
                return left.val + sumOfLeftLeaves(root.right);
            } else {
                return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
            }

        }
    }
}
