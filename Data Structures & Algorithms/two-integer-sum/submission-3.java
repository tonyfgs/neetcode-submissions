class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
       
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if (map.containsKey(search)) 
            {
                
                result[0] = map.get(search);
                result[1] = i;

                return result; 
            }
            map.putIfAbsent(nums[i], i);

        }
        return  result;
    }
}
