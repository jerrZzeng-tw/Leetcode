package leetcode.medium;

import leetcode.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        System.out.println(levelOrder(TreeNode.getTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        levelOrder(root, 0, lists);
        return lists;
    }

    public static void levelOrder(TreeNode node, int level, List<List<Integer>> lists) {
        if (node == null) {
            return;
        }
        if (lists.size() == level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(node.val);
        levelOrder(node.left, level + 1, lists);
        levelOrder(node.right, level + 1, lists);
    }
}
