class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size == 1){
            return nums[0];
        }
        int[] cache1 = new int[size];
        int[] cache2 = new int[size];
        Arrays.fill(cache1, -1);
        Arrays.fill(cache2, -1);
        return Math.max(dfs(0,  nums, size-1,cache1), dfs(1,  nums, size, cache2));
    }

    private int dfs(int index,int[] nums,int size,int[] cache){
        if (index >= size){
            return 0;
        }


        if(cache[index] != -1){
            return cache[index];
        }

        return cache[index] = Math.max(nums[index] + dfs( index+2, nums,size, cache), dfs(index+1, nums,size,cache));


    }
}
