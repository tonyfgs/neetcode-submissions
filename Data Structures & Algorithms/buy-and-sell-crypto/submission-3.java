class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int lower = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < prices[lower]) {
                lower = i;
                continue;
            }
            int current = prices[i] - prices[lower];
            max = Math.max(current, max);
        }
        return max;
    }
}
