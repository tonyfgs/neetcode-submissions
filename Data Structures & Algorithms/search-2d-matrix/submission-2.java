class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            if (target > matrix[i][row.length-1] ) {
                continue;
            }
            int end = row.length-1;
            int start = 0;
            int mid = 0;
            while (start <= end) {
                mid = start + (end - start)/2;

                if (row[mid] == target) {
                    return true;
                }
                if (row[mid] < target) start = mid + 1;   // trop petit → droite
                else end = mid - 1;     // trop grand → gauche
            }
            return false;


        }

        return false;
    }
}
