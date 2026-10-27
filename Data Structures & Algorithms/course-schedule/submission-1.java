class Solution {

    HashMap<Integer, HashSet<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         map = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            map.computeIfAbsent(prerequisites[i][0], k -> new HashSet<>()).add(prerequisites[i][1]);
        }

        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            if (!dfs(entry.getKey(), new HashSet<>())){
                return false;
            }
        }

        return true;

    }

    private boolean dfs(int node, HashSet<Integer> visited){
        if (visited.contains(node)) {
            return false;
        }
        HashSet<Integer> connected = map.get(node);
        if (connected == null){
            return true;
        }
        
        visited.add(node);

        for(Integer subCour: connected) {
            if(!dfs(subCour, visited)){
                return false;
            }
        }
        visited.remove(node);
        return true;
    }
}
