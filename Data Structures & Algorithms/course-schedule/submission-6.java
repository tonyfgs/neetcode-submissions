class Solution {

    HashMap<Integer, HashSet<Integer>> map;
    HashSet<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         map = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            map.computeIfAbsent(prerequisites[i][0], k -> new HashSet<>()).add(prerequisites[i][1]);
        }
        visited =  new HashSet<>();
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            if (!dfs(entry.getKey())){
                return false;
            }
        }

        return true;

    }

    private boolean dfs(int node){
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        HashSet<Integer> connected = map.get(node);
        if (connected == null || connected.isEmpty()){
            return true;
        }
        

        for(Integer subCour: connected) {
            if(!dfs(subCour)){
                return false;
            }
        }
        visited.remove(node);
        map.put(node, new HashSet<Integer>());
        return true;
    }
}
