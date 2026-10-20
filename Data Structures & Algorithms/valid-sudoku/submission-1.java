class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Character> column = new ArrayList<>();
        List<Character> row = new ArrayList<>();
        Map<String, Set<Character>> subbox = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char rowVal = board[i][j];    // Ligne i
                char colVal = board[j][i];    // Colonne i

                // 1. Validation ligne
                if (rowVal != '.') {
                    if (row.contains(rowVal)) return false;
                    row.add(rowVal);

                    // 2. Validation carré 3x3 (sur la case courante board[i][j])
                    String boxKey = (i / 3) + "-" + (j / 3);
                    subbox.putIfAbsent(boxKey, new HashSet<>());
                    if (subbox.get(boxKey).contains(rowVal)) return false;
                    subbox.get(boxKey).add(rowVal);
                }

                // 3. Validation colonne
                if (colVal != '.') {
                    if (column.contains(colVal)) return false;
                    column.add(colVal);
                }
            }
            // Réinitialisation pour la ligne et la colonne suivantes
            column.clear();
            row.clear();
        }

        return true;
    }
}