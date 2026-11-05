class Solution {
    public int coinChange(int[] coins, int amount) {
        int index = coins.length-1;
        int count = 0;
        while(index >= 0){
            if(coins[index] <= amount){
                amount -= coins[index];
                count++;
            }
            else {
                index--;
            }
        }
        if (amount == 0) 
            return count;
        return -1;
    }
}
