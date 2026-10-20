class Solution {
    public int findMin(int[] nums) {
        int min = 0;
        int max = nums.length-1;
        
        while(min < max) {
            int mid = min + (max-min) /2;

            if (nums[mid] >= nums[max]) {
                min = mid +1;
            }
            else {
                max  = mid;
            }
        }

        return nums[min];
    }
}
