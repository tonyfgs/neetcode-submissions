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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return nextLevel(root, new ArrayList(),0);
    }

    public List<List<Integer>> nextLevel(TreeNode root, List<List<Integer>> result, int layout) {
        if(root == null) return result;
        if( result.size() == layout) {
             result.add(layout, new ArrayList());
        }
        result.get(layout).add(root.val);
        
        result = nextLevel(root.left, result, layout+1);
        result = nextLevel(root.right, result, layout+1);
        return result;
    }
}
