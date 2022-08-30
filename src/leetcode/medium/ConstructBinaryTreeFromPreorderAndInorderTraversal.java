package leetcode.medium;

import leetcode.dataStructure.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4});
        System.out.println(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, preorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int index, int left, int right) {
        if (index >= preorder.length) {
            return null;
        }
        int pos = find(inorder, preorder[index], left, right);
        if (pos == -1) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        node.left = buildTree(preorder, inorder, index + 1, left, pos - 1);
        for (int i = index + 1; i < preorder.length; i++) {
            if (find(inorder, preorder[i], pos + 1, right) >= 0) {
                node.right = buildTree(preorder, inorder, i, pos + 1, right);
                break;
            }
        }
        return node;
    }

    public static int find(int[] inorder, int tager, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == tager) {
                return i;
            }
        }
        return -1;
    }
}
