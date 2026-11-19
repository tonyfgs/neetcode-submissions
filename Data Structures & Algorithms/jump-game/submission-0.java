class Solution {
    public boolean canJump(int[] nums) {
        int[] step = new int[nums.length];
        int foot = 0;


        
        for (int i=0; i<nums.length; i++) {
           foot+= nums[i];
           if (foot == 0) {
            return true;
           }
           foot--;
           
        }
        return false;
    }
}
