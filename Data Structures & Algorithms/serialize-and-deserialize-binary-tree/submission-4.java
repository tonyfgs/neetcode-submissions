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

public class Codec {

    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "null,";
        }
        String serializeString = String.valueOf(root.val) + ",";

        serializeString = serializeString + serialize(root.left);
        serializeString = serializeString + serialize(root.right);
        return serializeString;
    }

    Integer finger = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] deser = data.split(",");
        
        return deserrialize(deser);

    }

    private TreeNode deserrialize(String[] data) {
        
        

        String result = data[finger];
        finger++;
        if(result.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(result));
        node.left = deserrialize(data);
        node.right = deserrialize(data);
        

        
        return node;

    }
}
