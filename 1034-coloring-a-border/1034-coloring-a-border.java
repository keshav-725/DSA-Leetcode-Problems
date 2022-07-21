class Solution {
    int [][]dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int org = grid[row][col];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid,row,col,color,org,visited);
        return grid;
    }
    public int dfs(int [][]grid,int row,int col,int color,int org,boolean [][]visited){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length){
            return 0;
        }
        if(grid[row][col]!=org && visited[row][col]==false) return 0;
        // if(grid[row][col]==color && visited[row][col]==true) return 1;
        if(visited[row][col]==true) return 1;
        visited[row][col]=true;
        int up = dfs(grid,row-1,col,color,org,visited);
        int right = dfs(grid,row,col+1,color,org,visited);
        int bottom = dfs(grid,row+1,col,color,org,visited);
        int left = dfs(grid,row,col-1,color,org,visited);
        
        if(up==1 && right==1 && bottom ==1 && left==1){
            grid[row][col]=org;
        }else{
            grid[row][col]=color;
        }
        return 1;
    }
}