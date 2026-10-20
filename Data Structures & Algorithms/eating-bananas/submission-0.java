class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min =1;
        int max = 0;
        int k = 0;
        for(int bananas: piles){
            max  = Math.max(max, bananas);
        }
        
        
        while(min <= max) {
            k = min + (max - min) /2;
            int tmp = h;
            for(int bananas: piles){
                int time = (int) Math.ceil((double) bananas / k);  
                tmp = tmp - time;
            }
            if(tmp >= 0) {
                max = k -1;
            }
            else {
                min = k +1;
            }
        }

        return min;

    }
}
