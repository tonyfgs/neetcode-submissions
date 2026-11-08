class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount+1];
        Arrays.fill(cache, -2);
        return dfs(coins, amount, cache);

    }

    public int dfs(int[] coins, int amount,int[] cache)     
    {
        if (amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        if (cache[amount] != -2){
            return cache[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i= 0; i < coins.length; i++){

            int curr = dfs(coins, amount - coins[i], cache);
            if (curr != -1){
                min = Math.min(curr+1, min);
            }
            
        }

        cache[amount] = min == Integer.MAX_VALUE ? -1 : min ;


        return min == Integer.MAX_VALUE ? -1 : min;



    }
}
