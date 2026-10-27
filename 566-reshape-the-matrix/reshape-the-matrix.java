class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        
        // If the total number of elements doesn't match, return original matrix
        if (m * n != r * c) {
            return mat;
        }
        
        int[][] res = new int[r][c];
        int row = 0, col = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[row][col] = mat[i][j];
                col++;
                // If we reach the end of the current row, move to the next row
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        
        return res;
    }
}