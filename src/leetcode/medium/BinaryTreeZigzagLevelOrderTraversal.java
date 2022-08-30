package leetcode.medium;

import leetcode.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(TreeNode.getTree(new Integer[]{1, 2, 3, 4, null, null, 5})));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        zigzagLevelOrder(root, 0, lists);
        return lists;

    }

    public static void zigzagLevelOrder(TreeNode node, int level, List<List<Integer>> lists) {
        if (node == null) {
            return;
        }
        if (lists.size() == level) {
            lists.add(new LinkedList<>());
        }
        if (level % 2 == 1) {
            lists.get(level).add(0, node.val);
        } else {
            lists.get(level).add(node.val);
        }
        zigzagLevelOrder(node.left, level + 1, lists);
        zigzagLevelOrder(node.right, level + 1, lists);
    }
}
