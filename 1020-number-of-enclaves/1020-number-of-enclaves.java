class Solution {
    public int count = 0;
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean [][]visited = new boolean[row][col];
        int total = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) total++;
                if((i==0 || j==0 || i==row-1 || j==col-1) && visited[i][j]==false && grid[i][j]==1)                 {
                    dfs(grid,i,j,visited);   
                }
            }
        }
        return total-count;
    }
    public void dfs(int [][]grid,int row,int col,boolean [][]visited){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col]==true || grid[row][col]==0){
            return;
        }
        visited[row][col] = true;
        count++;
        dfs(grid,row-1,col,visited);
        dfs(grid,row+1,col,visited);
        dfs(grid,row,col-1,visited);
        dfs(grid,row,col+1,visited);
    }
}