class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }
        int currentSeq =0;
        int maxSeq =0;

        for (int num: set){
            if (set.contains(num-1)) {
                continue;
            }
            currentSeq =1;
            int currentNumber = num;
            while(set.contains(currentNumber+1)) {
                currentNumber++;
                currentSeq++;
            }
            maxSeq = Math.max(maxSeq, currentSeq);
            
        }

        return maxSeq;
    }
}
