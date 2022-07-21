package leetcode;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7});

        System.out.println(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int length = end - start + 1;
        if (length > 3) {
            int middle = (start + end) / 2;
            return new TreeNode(nums[middle], sortedArrayToBST(nums, start, middle - 1),
                    sortedArrayToBST(nums, middle + 1, end));
        }
        switch (length) {
            case 1:
                return new TreeNode(nums[start]);
            case 2:
                return new TreeNode(nums[start + 1], new TreeNode(nums[start]), null);
            case 3:
                return new TreeNode(nums[start + 1], new TreeNode(nums[start]), new TreeNode(nums[start + 2]));
            default:
                return null;
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
