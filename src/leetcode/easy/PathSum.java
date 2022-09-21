package leetcode.easy;

import leetcode.dataStructure.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        System.out.println(
                hasPathSum(TreeNode.getTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || targetSum <= 0) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }
}
