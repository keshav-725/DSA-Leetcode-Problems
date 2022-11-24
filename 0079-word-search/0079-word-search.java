class Solution {
    public boolean exist(char[][] board, String word) {
        char ch = word.charAt(0);
        boolean [][]vis = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(ch==board[i][j]){
                    boolean isExist = dfsBoard(board,vis,i,j,word,0);
                    if(isExist) return true;
                }
            }
        }
        return false;
    }
    public boolean dfsBoard(char[][] board, boolean[][] visitedBoard, int row, int col, String word, int wordInd) {        			
		if( (row < 0 || row >= board.length)   ||   (col < 0 || col >= board[0].length)  ||   board[row][col] != word.charAt(wordInd) ){
			return false;                                                                             
		}
		if(visitedBoard[row][col] ){ return false; }                                                  
		if(wordInd == word.length() - 1){ return true; }
		visitedBoard[row][col] = true;                                                                
			
		if( dfsBoard(board, visitedBoard, row, col-1, word, wordInd + 1) ){ return true; }            
		if( dfsBoard(board, visitedBoard, row, col+1, word, wordInd + 1) ){ return true; }            
		if( dfsBoard(board, visitedBoard, row-1, col, word, wordInd + 1) ){ return true; }            
		if( dfsBoard(board, visitedBoard, row+1, col, word, wordInd + 1) ){ return true; }            
		visitedBoard[row][col] = false;
		return false;
	}
}