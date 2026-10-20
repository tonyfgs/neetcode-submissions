class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) +1);
        }

        List<Integer>[] bucket = new List[nums.length +1];

        int freq =0;
        for(int key: freqMap.keySet()){
            freq = freqMap.get(key);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] result = new int[k];
        int index =0;

        for(int i = bucket.length-1; i>=0 && index < k; i--) {
             if (bucket[i] != null) {
            for (int num: bucket[i]){
                if (index < k){
                    result[index++] = num;
                }
            }
        }
        }
        return result;
    }
}
