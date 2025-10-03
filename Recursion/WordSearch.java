class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (abd(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    boolean abd(char[][] board, String word, int k, int i, int j) {
        if (k == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(k)) return false;

        char temp = board[i][j];
        board[i][j] = '#';  

        boolean found = abd(board, word, k+1, i+1, j) ||
                        abd(board, word, k+1, i-1, j) ||
                        abd(board, word, k+1, i, j+1) ||
                        abd(board, word, k+1, i, j-1);

        board[i][j] = temp; 
        return found;
    }
}
