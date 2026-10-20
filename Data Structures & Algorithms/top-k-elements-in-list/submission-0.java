class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> n = new HashMap();
        int[] res = new int[k]; 
        int index =0;
        for (int num: nums) {
           n.put(num, n.getOrDefault(num, 0) +1);
        }

        List<Integer>[] bucket = new List[nums.length +1];

        int freq = 0;
        for (int key: n.keySet()) {
            freq = n.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList();
            }
            bucket[freq].add(key);
        }

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
                if (bucket[i] != null) {
                for(int num: bucket[i]) {
                    res[index] = num;
                    index++;
                    if (index == k) {
                        return res;
                    }
                }
            }
        }


        return res;
    }
}
