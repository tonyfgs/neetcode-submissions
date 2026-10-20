class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length-1;
        int left = 0;

        while(right > left) {
            int rightValue = numbers[right];
            int leftValue = numbers[left];
            int sum = rightValue + leftValue;
            if (sum == target) {
                return new int[]{left +1, right+1};
            }
            if (sum > target) {
                right--;
            }
            else if (sum < target) {
                left++;
            }
        }
        return new int[]{left +1, right+1};
    }
}
