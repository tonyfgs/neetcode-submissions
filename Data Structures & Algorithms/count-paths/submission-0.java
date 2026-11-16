class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int[] ligne : cache) {
            Arrays.fill(ligne, -1);
        }
        return dfs(0, 0, cache, m, n);
    }

    private int dfs(int y, int x, int[][] cache, int m, int n) {
        if (y >= m || x >= n) {
            return 0;
        }

        if (y == m-1 && x == n-1) {
            return 1;
        }
        if (cache[y][x] != -1) {
            return cache[y][x];
        }

        int val =dfs(y + 1, x, cache, m, n) + dfs(y, x + 1, cache, m, n);
        cache[y][x] = val;
        return cache[y][x];
    }
}
