package leetcode.easy;

import leetcode.dataStructure.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindModeInBinarySearchTree {
    int max = 0;
    int count = 0;
    TreeNode pre = null;

    public static void main(String[] args) {
        FindModeInBinarySearchTree obj = new FindModeInBinarySearchTree();
        System.out.println(Arrays.toString(obj.findMode(TreeNode.getTree(new Integer[]{1, 2}))));
    }

    public int[] findMode(TreeNode root) {
        Set<Integer> res = new HashSet<>();
        inorder(root, res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void inorder(TreeNode node, Set<Integer> res) {
        if (node == null)
            return;
        inorder(node.left, res);
        if (pre == null || pre.val != node.val) {
            count = 1;
            pre = node;
        } else {
            count++;
        }
        if (count >= max) {
            if (count > max)
                res.clear();
            res.add(node.val);
            max = count;
        }
        inorder(node.right, res);
    }


}
