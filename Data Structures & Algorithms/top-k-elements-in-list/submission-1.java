class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) +1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        int freq =0;
        for(int key: frequency.keySet()) {
            freq = frequency.get(key);
            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);

        }

        int[] result = new int[k];
        int index =0;
        for(int i = buckets.length -1; i >= 0 && index < k; i --) {
             if (buckets[i] != null) {
            for(int num: buckets[i]) {
                if(index < k) {
                    result[index++] = num;
                }
            }
            }
        }
        return result;
    }
}
