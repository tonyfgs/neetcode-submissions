class Solution {
    public int maxArea(int[] heights) {
        int right = heights.length-1;
        int left = 0;
        int maxWater = 0;
        while(left < right) {

            int minBar = Math.min(heights[left], heights[right]);
            int water = (right - left ) * minBar;
            maxWater = Math.max(water, maxWater);

            if (heights[left] == minBar) {
                left++;
            }
            else {
                right--;
            }

        }

        return maxWater;
        
    }
}
