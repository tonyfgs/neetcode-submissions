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

    private int max = Integer.MIN_VALUE;


    public int maxPathSum(TreeNode root) {

        gain(root);
        return max;
    }

    public int gain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currentLeft = gain(root.left);
        int currentRight = gain(root.right);
        int curr = root.val + Math.max(0, currentRight) + Math.max(0, currentLeft);
        max = Math.max(curr, max);
        return root.val + Math.max(0, Math.max(currentRight,currentLeft));
    }
}
