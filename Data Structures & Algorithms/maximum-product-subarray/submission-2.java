class Solution {
    public int maxProduct(int[] nums) {
        int maxSum = 0;

        int currSum =1;
        int start = 0;
        int end = 0;

        if(nums.length == 1){
            return nums[0];
        }

        while(end < nums.length){
            if(nums[end] < 0){
                start = end +1;
                end = start;
                currSum = 1;
                continue;
            }

            currSum *= nums[end];
            maxSum = Math.max(maxSum, currSum);
            end = end +1;
        }

        return maxSum ;
    }
}
