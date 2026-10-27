class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];
        
        // Directions array for 8 neighbors plus the cell itself
        int[] directions = {-1, 0, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                
                // Check all 9 cells in the 3x3 grid
                for (int dr : directions) {
                    for (int dc : directions) {
                        int ni = i + dr;
                        int nj = j + dc;
                        
                        // Check if the neighbor is within matrix bounds
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                            sum += img[ni][nj];
                            count++;
                        }
                    }
                }
                
                // Store the rounded-down average
                result[i][j] = sum / count;
            }
        }
        
        return result;
    }
}