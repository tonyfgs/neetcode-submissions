class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int h; 
        for (int i =0; i<= heights.length; i++) {
            if (i == heights.length)
            {
                h = 0;
            }
            else {
                h = heights[i];
            }
            while(!stack.isEmpty() && h < heights[stack.peek()]) {
                int j = stack.pop();
                int largeur = i;
                if (!stack.isEmpty()) {
                   largeur = largeur - stack.peek() -1;
                }
                 
                maxArea = Math.max(maxArea, heights[j] * largeur);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
