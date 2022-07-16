class Solution {
    int [][]dist = {{-1,0},{0,-1},{1,0},{0,1}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean [][]visited = new boolean[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    checkIsland(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public void checkIsland(int row,int col,char [][]grid,boolean [][]visited){
        if(grid[row][col]=='0') return;
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int nrow = row+dist[i][0];
            int ncol = col+dist[i][1];
            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && visited[nrow][ncol]==false){
                checkIsland(nrow,ncol,grid,visited);
            }
        }
    }
}