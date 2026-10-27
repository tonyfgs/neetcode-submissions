class Solution {

    int height;
    int length;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        height = heights.length;
        length = heights[0].length;

        for (int row = 0; row<height; row++) {
            for (int column= 0; column<length; column++) {
                boolean pacific = dfs(row, column, heights, new boolean[height][length], heights[row][column],true);

                boolean atlantic = dfs(row, column, heights, new boolean[height][length], heights[row][column], false);


                if(pacific && atlantic) {
                    result.add(List.of(row,column));
                }
            }
        }

        return result;
    }

    private boolean dfs(int row, int column,int[][] heights, boolean[][] visited, int prev, boolean isPacific){
        if (row >= height || column >= length || row < 0 || column < 0) {
            return false;
        }

        if (heights[row][column] > prev) {
            return false;
        }
        if(isPacific && (row == 0 || column == 0)){
            return true;
        }
        else if (!isPacific && (row == height-1 || column == length-1)){
            return true;
        }

        if(visited[row][column] == true){
            return false;
        }

        
        visited[row][column] = true;


        return (
        dfs(row+1, column, heights, visited, heights[row][column], isPacific) ||
        dfs(row, column+1, heights, visited, heights[row][column], isPacific) ||
        dfs(row-1, column, heights, visited, heights[row][column], isPacific) ||
        dfs(row, column-1, heights, visited, heights[row][column], isPacific)
        );


    }
}
