/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    HashMap<Integer, Node> nodeMap;
    public Node cloneGraph(Node node) {
        if (node == null){
            return node;
        }
        nodeMap = new HashMap<>();
        return dfs(node);
    }


    private Node dfs(Node original) {
        if(nodeMap.containsKey(original.val)){
            return nodeMap.get(original.val);
        }

        Node copy = new Node(original.val);
        nodeMap.put(original.val, copy);

        for(Node nei: original.neighbors) {
            copy.neighbors.add(dfs(nei));
        }
        return copy;

    }
}