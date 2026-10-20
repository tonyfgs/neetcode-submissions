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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> heap = new ArrayDeque<>();

        TreeNode curr = root;

        while(curr != null || !heap.isEmpty()) {
            while(curr != null){
                heap.push(curr);
                curr = curr.left;
            }
            curr = heap.pop();
            k--;
            if(k == 0) return curr.val;
            curr = curr.right;
            
            
        }
        return -1;
    }
}
