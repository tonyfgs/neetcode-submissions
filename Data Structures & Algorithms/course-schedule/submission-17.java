class Solution {

    HashMap<Integer, HashSet<Integer>> map;
    int[] state;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         map = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            map.computeIfAbsent(prerequisites[i][0], k -> new HashSet<>()).add(prerequisites[i][1]);
        }
        state =  new int[numCourses];
        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            if (!dfs(entry.getKey())){
                return false;
            }
        }

        return true;

    }

    private boolean dfs(int node){
        if (state[node] == 1) {
            return false;
        }
        if (state[node] == 2) {
            return true;
        }

        HashSet<Integer> connected = map.get(node);
        if (connected == null){
            state[node] = 2;
            return true;
        }
        
        state[node] = 1;

        for(Integer subCour: connected) {
            if(!dfs(subCour)){
                return false;
            }
        }
        state[node] = 2;
        return true;
    }
}
