class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int tot = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                // Le mur limitant est côté gauche : on traite la barre gauche
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];   // nouveau mur vu
                } else {
                    tot += maxLeft - height[left];   // eau au-dessus de cette barre
                }
                left++;
            } else {
                // Le mur limitant est côté droit : symétrique
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    tot += maxRight - height[right];
                }
                right--;
            }
        }
        return tot;
    }
}