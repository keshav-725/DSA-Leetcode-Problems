class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea  = 0;
        for(int i = 0 ; i < grid.length;i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                   maxArea = Math.max(helper(grid,i,j),maxArea); // maximum area from all the islands we visited 
                }
            }
        }
        return maxArea;
    }
    public int helper(int[][] grid,int i, int j){
        if(i >= grid.length || i<0 || j >= grid[0].length || j< 0 || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0; 
        int count = 1; 
        count += helper(grid,i+1,j); 
        count += helper(grid,i,j-1); 
        count += helper(grid,i,j+1); 
        count += helper(grid,i-1,j); 
        return count; 
    }
}