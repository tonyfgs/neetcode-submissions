class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if (size < 2){
            return nums[0];
        }
        return dfs(nums,0, size);
    }


    private int dfs(int[] nums, int index, int size){
        if (size <= index){
            return 0;
        }
        return  Math.max(nums[index] +  dfs(nums,index+2, size),  dfs(nums,index+1, size));
    }
}
