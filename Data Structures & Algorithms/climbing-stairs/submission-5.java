class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);

        return dfs(0, n, cache);
    }

    private int dfs(int index, int target, int[] cache){
        if(index > target){
            return 0;
        }
        if (index == target){
            return 1;
        }
        if (cache[index] != -1){
            return cache[index];
        }
        
        return cache[index]  = dfs(index+1, target, cache) + dfs(index+2,target, cache);
       
    }
}
