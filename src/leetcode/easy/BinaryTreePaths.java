package leetcode.easy;

import leetcode.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        System.out.println(binaryTreePaths(TreeNode.getTree(new Integer[]{1, 2, 3, null, 5})));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        binaryTreePaths(root, String.valueOf(root.val), list);
        return list;
    }

    public static void binaryTreePaths(TreeNode root, String prePath, List<String> list) {
        if (root == null)
            return;

        if (root.left != null) {
            binaryTreePaths(root.left, prePath + "->" + root.left.val, list);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, prePath + "->" + root.right.val, list);
        }
        if (root.left == null && root.right == null)
            list.add(prePath);
    }
}
