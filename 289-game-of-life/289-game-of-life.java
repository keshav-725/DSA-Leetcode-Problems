class Solution {
    public void gameOfLife(int[][] board) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int col = board[0].length;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count = countNeighbour(board,i,j);
                int key = col*i+j;
                map.put(key,board[i][j]);
                if(board[i][j]==0){
                    if(count==3){
                        map.put(key,1);
                    }
                }else{
                    if(count<2){
                        map.put(key,0);
                    }else if(count==2 || count==3){
                        map.put(key,1);
                    }else if(count>3){
                        map.put(key,0);
                    }
                }
            }
        }
        int total = board.length * board[0].length;
        for(int i=0;i<total;i++){
            int r = i/col;
            int c = i%col;
            board[r][c] = map.get(i);
        }
        return;
    }
    public int countNeighbour(int[][] board,int i,int j){
        int count = 0;
        if(i-1>=0){
            if(board[i-1][j]==1) count++;
            if(j+1<board[0].length){
                if(board[i-1][j+1]==1) count++;
            }
            if(j-1>=0){
                if(board[i-1][j-1]==1) count++;
            }
        }
        if(i+1<board.length){
            if(board[i+1][j]==1) count++;
            if(j-1>=0){
                if(board[i+1][j-1]==1) count++;
            }
            if(j+1<board[0].length){
                if(board[i+1][j+1]==1) count++;
            }
        }
        if(j-1>=0 && board[i][j-1]==1) count++;
        if(j+1<board[0].length && board[i][j+1]==1) count++;
        
        return count;
    }
}