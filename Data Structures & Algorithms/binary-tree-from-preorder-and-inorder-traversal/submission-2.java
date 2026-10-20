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

    private int finger = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, inorder, 0, preorder.length-1);
    }

      public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
            if(start > end || finger > preorder.length-1) {
                return null;
            }
            TreeNode rootNode = new TreeNode(preorder[finger]);
            finger++;
            
            int indexRootInorder = start;

            while(inorder[indexRootInorder] != rootNode.val) {
                indexRootInorder++;
            } 

            rootNode.left = buildTree(preorder, inorder, start, indexRootInorder-1);
            rootNode.right = buildTree(preorder, inorder, indexRootInorder+1, end);

            return rootNode;
      

    }

}
