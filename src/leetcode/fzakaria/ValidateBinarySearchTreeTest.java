package leetcode.fzakaria;

public class ValidateBinarySearchTreeTest {

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

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSTHelper(TreeNode root, Long min, Long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBSTHelper(root.left, min, (long) root.val) &&
                isValidBSTHelper(root.right, (long) root.val, max);
    }
}
