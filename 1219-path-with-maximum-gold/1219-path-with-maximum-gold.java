class Solution {
    public int max = 0;
    public int getMaximumGold(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                boolean [][]visited = new boolean[grid.length][grid[0].length];
                checkMax(grid,visited,i,j,0);
            }
        }
        return max;
    }
    public void checkMax(int [][]grid,boolean [][]visited,int i,int j,int sum){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || visited[i][j]==true || grid[i][j]==0) return;
        max = Math.max(max,sum+grid[i][j]);
        visited[i][j]=true;
        checkMax(grid,visited,i-1,j,sum+grid[i][j]);
        checkMax(grid,visited,i+1,j,sum+grid[i][j]);
        checkMax(grid,visited,i,j-1,sum+grid[i][j]);
        checkMax(grid,visited,i,j+1,sum+grid[i][j]);
        visited[i][j]=false;
    }
}