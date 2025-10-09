import java.util.*;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        ArrayList<String> paths = new ArrayList<>();
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) return paths;
        boolean[][] visited = new boolean[n][n];
        backtrack(maze, n, 0, 0, "", visited, paths);
        return paths;
    }

    private void backtrack(int[][] maze, int n, int row, int col, String path, boolean[][] visited, ArrayList<String> paths) {
        if (row == n - 1 && col == n - 1) {
            paths.add(path);
            return;
        }
        visited[row][col] = true;
        if (isSafe(maze, visited, n, row + 1, col)) backtrack(maze, n, row + 1, col, path + "D", visited, paths);
        if (isSafe(maze, visited, n, row, col - 1)) backtrack(maze, n, row, col - 1, path + "L", visited, paths);
        if (isSafe(maze, visited, n, row, col + 1)) backtrack(maze, n, row, col + 1, path + "R", visited, paths);
        if (isSafe(maze, visited, n, row - 1, col)) backtrack(maze, n, row - 1, col, path + "U", visited, paths);
        visited[row][col] = false;
    }

    private boolean isSafe(int[][] maze, boolean[][] visited, int n, int row, int col) {
        return (row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1 && !visited[row][col]);
    }
}
