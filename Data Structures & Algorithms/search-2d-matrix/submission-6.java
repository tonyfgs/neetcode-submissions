class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int end = m * n  -1;

        while (start <= end){
            int mid = start + (end-start)/2;
            int value = matrix[mid/n][mid%n];

            if(value== target) {
                return true;
            }
            if (value < target) 
                start = mid +1;
            else 
                end  =mid -1;
        } 

        return false;
    }
}
