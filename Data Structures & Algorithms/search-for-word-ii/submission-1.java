class Solution {

    class PrefixTree {
        HashMap<Character, PrefixTree> map;

        boolean end;

        PrefixTree() {
            map = new HashMap<>();
            end = false;
        }
    }

    List<String> result;
    int height;
    int lenght;

    public List<String> findWords(char[][] board, String[] words) {
        PrefixTree root = new PrefixTree();
        height = board.length;
        lenght = board[0].length;
        result = new ArrayList<>();

        for(String word: words) {
            fillTree(root, word);
        }

        for(int i = 0; i < height; i++){
            for (int j =0; j < lenght; j++) {
                wordInPrefix(root, new StringBuilder(), i, j, board);
            }
        }
        return result;
    }

    private void wordInPrefix(PrefixTree root, StringBuilder current, int row, int column, char[][] matrix) {

        if (row < 0 || row >= height || column < 0 || column >= lenght || matrix[row][column] == '#'){
            return;
        }
        PrefixTree tmp = root.map.get(matrix[row][column]);
        if(tmp == null){
            return;
        }
        current.append(matrix[row][column]);
        if(tmp.end) {
            result.add(new String(current));
            tmp.end = false;
        }
        char backUp = matrix[row][column];
        matrix[row][column] = '#';
    
        wordInPrefix(tmp, current, row + 1, column, matrix);
        wordInPrefix(tmp, current, row, column+1, matrix);
        wordInPrefix(tmp, current, row -1, column, matrix);
        wordInPrefix(tmp, current, row, column-1, matrix);
        current.deleteCharAt(current.length() - 1);
        matrix[row][column] = backUp;
    }

    private void fillTree(PrefixTree root, String word) {
        PrefixTree cursor = root;
        for(int i = 0; i < word.length(); i++) {
            PrefixTree tmp = cursor.map.get(word.charAt(i));

            if(tmp == null) {
                tmp = new PrefixTree();
                cursor.map.put(word.charAt(i), tmp);
            }
            cursor = tmp;
        }
        cursor.end = true;

    }
}
