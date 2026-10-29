class Solution {
    class UFNode {
        UFNode parent;

        UFNode(){
            this.parent = this;
        }
    }

    public int countComponents(int n, int[][] edges) {
        int result = 0;
        UFNode[] parents = new UFNode[n];
        for (int i = 0; i < n; i++) {
            parents[i] = new UFNode();
        }
        for (int[] connection: edges){
            int node1 = connection[0];
            int node2 = connection[1];
            UFNode parent1 = parents[node1];
            UFNode parent2 = parents[node2];

            if(union(parent1, parent2)){
                result++;
            }
        }
        return n-result;
    }

    private boolean union(UFNode valA, UFNode valB){
        UFNode rootB = find(valB);
        UFNode rootA = find(valA);
        if (rootA == rootB){
            return false;
        }
        rootB.parent = rootA;
        return  true;
    }

    private UFNode find(UFNode val){
        if (val.parent == val){
            return val;
        }
        return find(val.parent);
    }
}
