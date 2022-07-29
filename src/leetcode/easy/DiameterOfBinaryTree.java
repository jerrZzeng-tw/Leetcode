package leetcode.easy;

import leetcode.dataStructure.TreeNode;

public class DiameterOfBinaryTree {
    int max = 0;

    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{1, 2, 3, 4, 5};
        TreeNode root = TreeNode.getTree(nodes);
        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        System.out.println(obj.diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxLength(root);
        return max;
    }

    public int maxLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxLength(node.left);
        int right = maxLength(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

}
