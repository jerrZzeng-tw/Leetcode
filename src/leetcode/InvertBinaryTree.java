package leetcode;

import leetcode.dataStructure.TreeNode;

public class InvertBinaryTree {

    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNode.getTree(nodes);
        invertTree(root);
        System.out.println(root);
    }

    public static TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode temp;
        temp = node.right;
        node.right = invertTree(node.left);
        node.left = invertTree(temp);
        return node;
    }
}
