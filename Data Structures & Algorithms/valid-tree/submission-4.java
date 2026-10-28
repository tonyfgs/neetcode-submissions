class Solution {

    
    
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        HashSet<Integer> visited = new HashSet<>();
       
        for (int[] connect: edges){
            map.computeIfAbsent(connect[0], k -> new HashSet<>()).add(connect[1]);
            map.computeIfAbsent(connect[1], k -> new HashSet<>()).add(connect[0]);
        }

        if(dfs(0,-1, map, visited) && visited.size() == n){
            return true;
        }
        return false;
    }

    private boolean dfs(int node, int prev, HashMap<Integer, HashSet<Integer>> map, HashSet<Integer> visited) {
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);
        
        HashSet<Integer> neight = map.get(node);
        if (neight == null || neight.isEmpty()) {
            return true;
        }
        

        for(Integer n: neight){
            if (n == prev){
                continue;
            }
            if(!dfs(n, node, map, visited)){
                return false;
            }
        }

        return true;
    }
}
