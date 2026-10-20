class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> columnSet = new HashSet<>();
        TreeMap<String, Set<Character>> subBox = new TreeMap<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char row = board[i][j];
                char colunm = board[j][i];
                if (row != '.') {
                    if (rowSet.contains(row)) {
                        return false;
                    }
                    rowSet.add(row);
                    String subKey = (i/3) + "-" + (j/3);
                    subBox.putIfAbsent(subKey, new HashSet<>());
                    if (subBox.get(subKey).contains(row)) {
                        return false;
                    }
                    subBox.get(subKey).add(row);
                    

                }
                if (colunm != '.') {
                    if (columnSet.contains(colunm)) {
                        return false;
                    }
                    columnSet.add(colunm);
                }
            }
            rowSet.clear();
            columnSet.clear();
        }
        return true;
    }
}
