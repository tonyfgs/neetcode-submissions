class Solution {
    public int trap(int[] height) {
    int left = 0;
    int right = height.length -1;
    int i = 0;
    int tot = 0;
    while(left<right) {
        if (height[left] <= height[right] ) {
            i = left+1;
            while (i < right && height[i] < height[left]) {
                tot += (height[left] - height[i]);
                i++;
            }
            left = i;
        }
        else {
            i = right-1;
             while (i > left && height[i] < height[right]) {
                tot += (height[right] - height[i]);
                i--;
            }
            right = i;        
        }
    }

    return tot;
    
    
    }

}
