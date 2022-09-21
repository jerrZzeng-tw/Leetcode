package leetcode.easy;

import leetcode.dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        System.out.println(minDepth_best(TreeNode.getTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else {
            return minDepth(root.left) + 1;
        }
    }

    public static int minDepth_best(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int o = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            o++;
            while (size-- > 0) {
                root = q.poll();
                if (root.left != null)
                    q.offer(root.left);
                if (root.right != null)
                    q.offer(root.right);
                if (root.left == null && root.right == null)
                    return o;
            }
        }
        return 0;
    }
}
