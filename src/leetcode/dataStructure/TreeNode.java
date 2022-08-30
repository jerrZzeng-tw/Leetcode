package leetcode.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public static TreeNode getTree(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        //        return getTree(nums, 0);
        TreeNode root = new TreeNode(nums[0]);
        getTree(nums, 1, Arrays.asList(root));
        return root;
    }

    public static void getTree(Integer[] nums, int index, List<TreeNode> nodes) {
        if (index >= nums.length) {
            return;
        }

        for (TreeNode node : nodes) {
            if (index < nums.length) {
                if (nums[index] != null) {
                    node.left = new TreeNode(nums[index]);
                }
                index++;
            }
            if (index < nums.length) {
                if (nums[index] != null) {
                    node.right = new TreeNode(nums[index]);
                }
                index++;
            }
        }
        getTree(nums, index, getChild(nodes));
    }

    public static List<TreeNode> getChild(List<TreeNode> nodes) {
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
        return list;
    }
}
