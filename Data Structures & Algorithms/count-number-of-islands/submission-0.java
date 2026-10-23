class Solution {

    int[][] visit;
    int height ;
    int lenght ;
    public int numIslands(char[][] grid) {
        height = grid.length;
        lenght = grid[0].length;
        int arbre = 0;
        visit = new int[height][lenght];
        for (int i = 0; i < height; i++) {
            for (int j =0; j < lenght; j++) {
                if(grid[i][j] == '1' && visit[i][j] == 0){
                    dfs(i, j, grid);
                    arbre++;
                    visit[i][j] = 1;
                }
            }
        }
        return arbre;
    }

    private void dfs(int row, int column, char[][] grid) {
        if(row < 0 || column < 0 || row >= height || column >= lenght){
            return;
        }
        if (grid[row][column] == '0' ||  visit[row][column] == 1){
            return;
        }
        visit[row][column] = 1;
        dfs(row +1, column, grid);
        dfs(row -1, column, grid);
        dfs(row, column +1, grid);
        dfs(row, column -1, grid);
        return;
    }
}
