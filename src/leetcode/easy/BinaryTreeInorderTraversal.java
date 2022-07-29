package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2, new TreeNode(3), null);

        List<Integer> list = inorderTraversal(root);
        list.forEach(System.out::println);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorderTraversal(root, list);
        return list;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right, list);
            }
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
