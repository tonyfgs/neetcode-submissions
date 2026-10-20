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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;                    // fenêtre vide → rien à construire

        TreeNode root = new TreeNode(preorder[preStart]);      // ② la racine du morceau

        int rootIndex = inStart;                               // cherche-la dans l'inorder
        while (inorder[rootIndex] != root.val) rootIndex++;

        int leftSize = rootIndex - inStart;                    // la taille de l'équipe gauche

        root.left  = build(preorder, preStart + 1, preStart + leftSize,      // ③ gauche
                           inorder,  inStart,       rootIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,        // ③ droite
                           inorder,  rootIndex + 1,  inEnd);                 // ④ combine
        return root;
    }
}
