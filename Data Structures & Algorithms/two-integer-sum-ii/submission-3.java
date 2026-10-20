class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length-1;
        int left = 0;

        while(left < numbers.length && right > left) {
            int sum = numbers[right] + numbers[left];
            if (sum == target) {
                return new int[]{left +1, right+1};
            }
            if (sum > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return new int[]{left +1, right+1};
    }
}
