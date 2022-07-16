class Solution {
    int [][]dist = {{-1,0},{0,-1},{1,0},{0,1}};
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    checkIsland(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void checkIsland(int row,int col,char [][]grid){
        grid[row][col]='0';
        for(int i=0;i<4;i++){
            int nrow = row+dist[i][0];
            int ncol = col+dist[i][1];
            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]=='1'){
                checkIsland(nrow,ncol,grid);
            }
        }
    }
}