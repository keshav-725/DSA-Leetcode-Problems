class Solution {
    public int minPathSum(int[][] grid) {
        Integer [][]dp = new Integer[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else if(i==0) dp[i][j] = dp[i][j-1]+grid[i][j];
                else if(j==0) dp[i][j] = dp[i-1][j]+grid[i][j];
                else{
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
    public int getSum(int row,int col,int [][]grid,Integer [][]dp){
        if(row>=grid.length || col>=grid[0].length) return -1;
        if(row==grid.length-1 && col==grid[0].length-1){
            return grid[row][col];
        }
        if(dp[row][col]!=null) return dp[row][col];
        int left = getSum(row+1,col,grid,dp);
        int right = getSum(row,col+1,grid,dp);
        if(left==-1) return dp[row][col]=right+grid[row][col];
        if(right==-1) return dp[row][col]=left+grid[row][col];
        return dp[row][col]=Math.min(left,right)+grid[row][col];
    }
}