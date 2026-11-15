class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] historic = new int[nums.length];
        Arrays.fill(historic, -1);
        int best = 1;
        for (int i =0; i < nums.length; i++) {
            best = Math.max(best, dfs(i, nums, historic)) ;
        }
        return best;
    }



    public int dfs(int index, int[] nums, int[] historic){

        if (historic[index] != -1) {
            return historic[index];
        }
        int best = 1;
        
        for (int i = index+1; i < nums.length; i++){
            if (nums[i] <= nums[index]){
                continue;
            }
            best = Math.max(best , 1+ dfs(i, nums, historic));
        }

        historic[index] = best;

        return best;



    }
}
