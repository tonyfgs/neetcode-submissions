class Solution {

    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, curr, target, 0);
        return result;
    }

    private void dfs(int[] nums, List<Integer> curr, int target, int index) {
        
        for(int i = index; i<nums.length; i++) {
            if (target-nums[i] < 0) {
                continue;
            }
            curr.add(nums[i]); 
            if (target-nums[i] == 0){
                result.add(List.copyOf(curr));
            }
            dfs(nums, curr,target-nums[i], i);
            curr.remove(curr.size()-1);
        }
    }

}
