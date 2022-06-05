class Solution {
    
   int answer;
    public int totalNQueens(int n) {
        
        answer = 0;
        
        // create a n*n chessboard
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        
        placeNQueens(board, 0, n); // 0 is row number(we will fill rowwise)
        
        return answer;
    }
    
    private void placeNQueens(char[][] board, int row, int n){
        
        // base case
        if(row == n){
            answer++; // valid configuration found
            return;
        }
        
        // check for all columns
            // check if its safe to place queen
                // if its safe -> then place the queen and move to next row
        for(int col = 0; col < n ; col++){
            if (isSafe(board, row, col, n)){
                board[row][col] = 'Q';
                placeNQueens(board, row+1, n);
                board[row][col] = '.'; // remove queen while backtracking
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col, int n){

        // check column on upper side
        for (int i = row; i >= 0; i--){
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        // check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        // check upper diagonal on right side
        for (int i = row, j = col; i >= 0 && j < n; i--, j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}