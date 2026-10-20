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
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queu = new ArrayDeque<>();
        queu.add(root);

        while(!queu.isEmpty()) {
            int size = queu.size();

            List<Integer> layout = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queu.poll();
                layout.add(cur.val);
                if(cur.left != null) queu.add(cur.left);
                if(cur.right != null) queu.add(cur.right);
            }
            result.add(layout);
        }

        return result;
    }


}
