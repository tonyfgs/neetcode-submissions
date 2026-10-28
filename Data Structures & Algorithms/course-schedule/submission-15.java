class Solution {

    HashMap<Integer, HashSet<Integer>> map;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         map = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            map.computeIfAbsent(prerequisites[i][0], k -> new HashSet<>()).add(prerequisites[i][1]);
        }
        visited =  new int[numCourses];
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            if (!dfs(entry.getKey())){
                return false;
            }
        }

        return true;

    }

    private boolean dfs(int node){
        if (visited[node] == 1) {
            return false;
        }
        if (visited[node] == 2) {
            return true;
        }

        HashSet<Integer> connected = map.get(node);
        if (connected == null || connected.isEmpty()){
            return true;
        }
        
        visited[node] = 1;

        for(Integer subCour: connected) {
            if(!dfs(subCour)){
                return false;
            }
        }
        visited[node] = 2;
        map.put(node, new HashSet<>());
        return true;
    }
}
