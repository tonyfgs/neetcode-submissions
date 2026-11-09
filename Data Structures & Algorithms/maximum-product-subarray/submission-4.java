class Solution {
    public int maxProduct(int[] nums) {
        int resultMax = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++){
            
            int tmpMax = nums[i] * currMax;
            int tmpMin = nums[i] * currMin;

            currMax = Math.max(nums[i],Math.max(tmpMax,tmpMin ) );
            currMin = Math.min(nums[i],Math.max(tmpMax,tmpMin ) );
            resultMax = Math.max(resultMax, currMax);
        }

        return resultMax;
    }
}
