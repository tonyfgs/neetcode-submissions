class Solution {

    
    
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        HashSet<Integer> visited = new HashSet<>();
       
        for (int[] connect: edges){
            map.computeIfAbsent(connect[0], k -> new HashSet<>()).add(connect[1]);
            map.computeIfAbsent(connect[1], k -> new HashSet<>()).add(connect[0]);
        }

        dfs(0, map, visited);
return visited.size() == n;
    }

private void dfs(int node, HashMap<Integer, HashSet<Integer>> map, HashSet<Integer> visited) {
    visited.add(node);
    for (int next : map.getOrDefault(node, new HashSet<>())) {
        if (!visited.contains(next)) {
            dfs(next, map, visited);
        }
    }
}
}
