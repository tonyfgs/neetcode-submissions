class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] setRow = new HashSet[9];
        Set<Character>[] setColumn = new HashSet[9];
        Set<Character>[] setSub = new HashSet[9];
        for (int i = 0; i <9; i++) {
            setRow[i] = new HashSet<>();
            setColumn[i]  = new HashSet<>();
            setSub[i] = new HashSet<>(); 
        }

        for (int i = 0; i < board.length; i++) {
            for(int j =0; j < board.length; j++) {
                char val = board[i][j];
                if (val == '.') {
                    continue;
                }
                
                int subBox = (i/3) *3 + j/3;

             
                if (setRow[j].contains(val) || 
                setColumn[i].contains(val) || 
                setSub[subBox].contains(val))
                {
                    return false;
                }
                setRow[j].add(val);
                setColumn[i].add(val);
                setSub[subBox].add(val);
            }
        }
        return true;
    }
}
