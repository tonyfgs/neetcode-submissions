class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        if(text1.equals(text2)){
            return text1.length();
        }

        int row = text1.length();
        int column = text2.length();

        int[][] cache = new int[row][column];

        for (int i =0; i < row; i++) {
            Arrays.fill(cache[i], -1);
        }

        return dfs(0, 0, text1, text2, cache);
    }

    private int dfs(int row, int column, String text1, String text2, int[][] cache) {
        if(row >= text1.length() || column >= text2.length()) {
            return 0;
        }

        if(cache[row][column] != -1) {
            return cache[row][column];
        }

        int best = 1;

        if(text1.charAt(row) == text2.charAt(column)) {
            cache[row][column] = 1+dfs(row+1, column+1, text1, text2, cache);
            return cache[row][column];
        }

        int val = Math.max(dfs(row, column+1, text1, text2, cache), dfs(row+1, column, text1, text2, cache));
        cache[row][column] = val;
        return val;
    }
}
