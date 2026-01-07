/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static long sum;
    static long max;
    static int MODULO = 1000000007;

    private static long getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + getSum(root.left) + getSum(root.right);
    }

    private static long getMaxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long left = getMaxProduct(root.left);
        long right = getMaxProduct(root.right);

        long t1 = left + right + root.val;
        long temp = (sum - t1) * t1;
        if (temp > max) {
            max = temp;
        }
        return t1;
    }

    public static int maxProduct(TreeNode root) {
        max = 0;
        sum = getSum(root);
        getMaxProduct(root);
        return (int) (max % MODULO);
    }
}