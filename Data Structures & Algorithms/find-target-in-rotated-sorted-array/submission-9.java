class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length-1;

        while(min<=max) {
            int mid = min + (max-min)/2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > nums[max]){
                if(target >= nums[min] && target < nums[mid]){
                    max = mid-1;
                }
                else  {
                    min = mid +1;
                }
                
            }
            else {
                if(target > nums[mid] && target <= nums[max]){
                    min = mid +1;
                }
                else  {
                    max = mid-1;
                }
            }
        }

        return -1;
    }
}
