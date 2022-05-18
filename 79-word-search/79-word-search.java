class Solution {
    boolean isExist;
    public boolean exist(char[][] board, String word) {
        isExist = false;
        char ch = word.charAt(0);
        boolean [][]vis = new boolean[board.length][board[0].length];
        findCharPosition(board,vis,ch,0,0,word);
        return isExist;
    }
    public void findCharPosition(char[][] board,boolean [][]visited,char ch,int row,int col,String word){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || visited[row][col]==true) return;
        if(ch==board[row][col]){
            //System.out.println(ch);
            boolean [][]vis = new boolean[board.length][board[0].length];
            checkExist(board,vis,row,col,""+ch,word,0);
            //System.out.println("___________________________________________");
        }
        visited[row][col]=true;
        findCharPosition(board,visited,ch,row+1,col,word);
        findCharPosition(board,visited,ch,row-1,col,word);
        findCharPosition(board,visited,ch,row,col+1,word);
        findCharPosition(board,visited,ch,row,col-1,word);
    }
    public void checkExist(char[][] board,boolean [][]vis,int i,int j,String words,String word,int count){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || vis[i][j]==true || count>=word.length() || word.charAt(count)!=board[i][j]) return;
        //System.out.println(words);
        //String tword = words+board[i][j];
        if(word.equals(words)){
            isExist = true;
        }
        vis[i][j]=true;
        if(i+1<board.length) checkExist(board,vis,i+1,j,words+board[i+1][j],word,count+1);
        if(i-1>=0) checkExist(board,vis,i-1,j,words+board[i-1][j],word,count+1);
        if(j+1<board[0].length) checkExist(board,vis,i,j+1,words+board[i][j+1],word,count+1);
        if(j-1>=0) checkExist(board,vis,i,j-1,words+board[i][j-1],word,count+1);
        vis[i][j]=false;
    }
}