class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> seeing = new ArrayList<>();

        for(int num: nums) {
            if (seeing.contains(num)){
                return true;
            }
            seeing.add(num);
        }
        return false;
    }
}