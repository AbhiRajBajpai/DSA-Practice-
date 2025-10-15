class Solution {
     int[][] dirs = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return backtrack(grid, visited, 0, 0, 0);
    }

     boolean backtrack(int[][] grid, boolean[][] visited, int x, int y, int step) {
        int n = grid.length;

        if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || grid[x][y] != step)
            return false;

        if (step == n * n - 1)
            return true;
        visited[x][y] = true;

        for (int i = 0; i < dirs.length; i++) {
    int newX = x + dirs[i][0];
    int newY = y + dirs[i][1];
    if (backtrack(grid, visited, newX, newY, step + 1))
        return true;

        }    
         visited[x][y] = false; 
        return false;
    
}
}
