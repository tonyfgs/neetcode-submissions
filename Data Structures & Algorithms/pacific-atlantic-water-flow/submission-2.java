class Solution {

    int height;
    int length;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        height = heights.length;
        length = heights[0].length;

        boolean[][] pac = new boolean[height][length];
        boolean[][] atl = new boolean[height][length];
        
        for (int row = 0; row < height; row ++) {
            dfs(row, 0,pac, heights, heights[row][0]);
            dfs(row, length-1,atl, heights, heights[row][length-1]);
        }

        for (int column = 0; column < length; column ++) {
            dfs(0, column,pac, heights, heights[0][column]);
            dfs(height-1, column,atl, heights, heights[height-1][column]);
        }

        for(int i = 0; i < height; i++){
            for (int j = 0; j< length; j++){
                if(pac[i][j] && atl[i][j]){
                    result.add(List.of(i, j));
                }
            }
        }
        
        return result;
    }

    private void dfs(int row, int column, boolean[][] ocean,int[][] heights, int prev){
        if (row >= height ||column >= length || row < 0 || column < 0){
            return;
        }
        if (prev > heights[row][column]) {
            return;
        }
        if (ocean[row][column] == true){
            return;
        }

        ocean[row][column] = true;

        dfs(row +1, column,ocean,  heights, heights[row][column]);
        dfs(row -1, column,ocean,  heights, heights[row][column]);

        dfs(row, column+1,ocean,  heights, heights[row][column]);
        dfs(row, column-1,ocean,  heights, heights[row][column]);


    }
}
