import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n]; 
        Arrays.fill(queens, -1);
        backtrack(0, n, queens, result);
        return result;
    }

    private void backtrack(int row, int n, int[] queens, List<List<String>> result) {
        if (row == n) {
            result.add(construct(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                queens[row] = col;  // place queen
                backtrack(row + 1, n, queens, result);
                queens[row] = -1;   
            }
        }
    }

    private boolean isSafe(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false; 
            }
        }
        return true;
    }

    private List<String> construct(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
