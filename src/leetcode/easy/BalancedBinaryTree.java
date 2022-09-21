package leetcode.easy;

import leetcode.dataStructure.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        System.out.println(isBalanced_best(TreeNode.getTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isBalanced(root.left) && isBalanced(root.right)) {
            int left = getHigh(root.left);
            int right = getHigh(root.right);
            if (Math.abs(left - right) > 1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static int getHigh(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHigh(node.left), getHigh(node.right)) + 1;
    }

    public static boolean isBalanced_best(TreeNode root) {
        return getHightAndCheck(root) != -1;
    }

    /**
     * 回傳 -1表示 平衡樹檢查失敗
     * 其他表示該NODE的高度
     *
     * @param node
     * @return
     */
    public static int getHightAndCheck(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getHightAndCheck(node.left);
        if (left == -1) {
            return -1;
        }
        int right = getHightAndCheck(node.right);
        if (right == -1) {
            return -1;
        }

        // 差距超過1 平衡樹檢查失敗
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        // 回傳平衡樹高度
        return Math.max(left, right) + 1;
    }
}
