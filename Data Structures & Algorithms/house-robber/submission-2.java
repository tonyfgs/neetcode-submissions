class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        int[] cache= new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(nums,0, size, cache);
    }


    private int dfs(int[] nums, int index, int size, int[] cache){
        if (size <= index){
            return 0;
        }

        if (cache[index] != -1) {
            return cache[index];
        }
        cache[index] = Math.max(nums[index] +  dfs(nums,index+2, size, cache),  dfs(nums,index+1, size, cache));
        return  cache[index];
    }
}
