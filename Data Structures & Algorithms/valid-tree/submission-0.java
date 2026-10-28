class Solution {

    HashMap<Integer, HashSet<Integer>> map;
    HashSet<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        map = new HashMap<>();
        visited = new HashSet<>();
        if (n == 0){
            return true;
        }
        for (int[] connect: edges){
            map.computeIfAbsent(connect[0], k -> new HashSet<>()).add(connect[1]);
            map.computeIfAbsent(connect[1], k -> new HashSet<>()).add(connect[0]);
        }

        if(dfs(0,-1) && visited.size() == n){
            return true;
        }
        return false;
    }

    private boolean dfs(int node, int prev) {
        if(visited.contains(node)){
            return false;
        }
        HashSet<Integer> neight = map.get(node);
        if (neight == null || neight.isEmpty()) {
            return true;
        }
        visited.add(node);

        for(Integer n: neight){
            if (n == prev){
                continue;
            }
            if(!dfs(n, node)){
                return false;
            }
        }

        return true;
    }
}
