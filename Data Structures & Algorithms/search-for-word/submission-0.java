class Solution {

    private static Integer height;
    private static Integer length;

    public boolean exist(char[][] board, String word) {
        height = board.length;
        length = board[0].length;

        Set<Double> path = new HashSet<>();


        for (int i =0; i < height; i++) {
            for(int j =0; j < length; j++) {
                if (dfs(board, word, path, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,String word,Set<Double> path, Integer column,Integer row) {
        if(column >= height || row >= length || row < 0 || column < 0) {
            return false;
        }
        boolean res = false;
        double pathWay = row+(column/10.0);
        if(board[column][row] == word.charAt(path.size()) && !path.contains(pathWay)){
            path.add(pathWay);
            if(word.length() == path.size()) {
                return true;
            }
        }
        else {
            return false;
        }
        res =(dfs(board, word, path, column,row+1) 
        || dfs(board, word, path, column+1,row) 
        || dfs(board, word, path, column, row-1)
        || dfs(board, word, path, column-1,row));

        path.remove(pathWay);
        return res;
    }
}
