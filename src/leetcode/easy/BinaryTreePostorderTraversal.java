package leetcode.easy;

import leetcode.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        System.out.println(postorderTraversal(TreeNode.getTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        //        List<Integer> result = new ArrayList<Integer>();
        //        postorderTraversal_Recursive(root, result);
        //        return result;
        return postorderTraversal_stack(root);
    }

    public static List<Integer> postorderTraversal_stack(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if (root != null)
            st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node.left == null && node.right == null) {
                result.add(node.val);
                st.pop();
            }
            if (node.right != null) {
                st.push(node.right);
                node.right = null;
            }
            if (node.left != null) {
                st.push(node.left);
                node.left = null;
            }
        }
        return result;
    }

    public static void postorderTraversal_Recursive(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postorderTraversal_Recursive(node.left, list);
        postorderTraversal_Recursive(node.right, list);
        list.add(node.val);
    }
}
