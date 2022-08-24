class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> result = new ArrayList<>();
        
        for (char[] ch : board)
            Arrays.fill(ch, '.');
        
        backtrack(0, result, new HashSet<String>(), board);
        
        return result;
    }
    
    private void backtrack(int row, List<List<String>> result, HashSet<String> set, char[][] board) {
        if (row == board.length) {
            List<String> ans = new ArrayList<>();
            
            for (char[] rows : board) {
                String stringifiedRow = new String(rows);
                ans.add(stringifiedRow);
            }
            
            result.add(ans);
        }
        
        for (int col = 0; col < board[0].length; col++) {
            if (!isValidCell(row, col, set)) continue;
            
            board[row][col] = 'Q';
            addVisited(row, col, set);
            
            backtrack(row + 1, result, set, board);
            
            board[row][col] = '.';
            removeVisited(row, col, set);
        }
    }
    
    private boolean isValidCell(int row, int col, HashSet<String> set) {
        return !set.contains("Column " + col) && !set.contains("Positive Diagonal " + (row + col)) && !set.contains("Negative Diagonal " + (row - col));
    }
    
    private void addVisited(int row, int col, HashSet<String> set) {
        set.add("Column " + col);
        set.add("Positive Diagonal " + (row + col));
        set.add("Negative Diagonal " + (row - col));
    }
    
    private void removeVisited(int row, int col, HashSet<String> set) {
        set.remove("Column " + col);
        set.remove("Positive Diagonal " + (row + col));
        set.remove("Negative Diagonal " + (row - col));
    }
}