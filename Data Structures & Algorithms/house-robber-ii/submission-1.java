class Solution {
    int from =0;
    public int rob(int[] nums) {
        int size = nums.length;
        if(size == 1){return nums;}
        int[] cache = new int[size];
        Arrays.fill(cache, -1);
        return dfs(0,  nums, size, cache);
    }

    private int dfs(int index,int[] nums,int size,int[] cache){
        if (index >= size){
            from++;
            return 0;
        }
        if(index == size-1 && from == 0){

            return 0;
        }

        if(cache[index] != -1){
            return cache[index];
        }

        return cache[index] = Math.max(nums[index] + dfs( index+2, nums,size, cache), dfs(index+1, nums,size,cache));


    }
}
