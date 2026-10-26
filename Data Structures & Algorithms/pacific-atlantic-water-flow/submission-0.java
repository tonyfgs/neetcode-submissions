class Solution {
    private int rows;
    private int cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Une recherche independante par ocean, chacune avec son visited
                boolean pac = reaches(r, c, heights, new boolean[rows][cols], true, heights[r][c]);
                boolean atl = reaches(r, c, heights, new boolean[rows][cols], false, heights[r][c]);
                if (pac && atl) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    private boolean reaches(int r, int c, int[][] heights,
                            boolean[][] visited, boolean pacific, int prev) {
        // Condition de bord : la cellule touche l'ocean cible
        if (pacific) {
            if (r == 0 || c == 0) return true;
        } else {
            if (r == rows - 1 || c == cols - 1) return true;
        }

        // L'eau ne remonte pas : la cellule doit etre <= a celle d'ou on vient
        if (heights[r][c] > prev) return false;

        // Deja explore par cette recherche -> inutile d'y retourner
        if (visited[r][c]) return false;
        visited[r][c] = true;

        int h = heights[r][c];

        // Les quatre directions sont toujours permises
        if (r + 1 < rows && heights[r + 1][c] <= h
                && reaches(r + 1, c, heights, visited, pacific, h)) return true;
        if (r - 1 >= 0 && heights[r - 1][c] <= h
                && reaches(r - 1, c, heights, visited, pacific, h)) return true;
        if (c + 1 < cols && heights[r][c + 1] <= h
                && reaches(r, c + 1, heights, visited, pacific, h)) return true;
        if (c - 1 >= 0 && heights[r][c - 1] <= h
                && reaches(r, c - 1, heights, visited, pacific, h)) return true;

        return false;
    }
}