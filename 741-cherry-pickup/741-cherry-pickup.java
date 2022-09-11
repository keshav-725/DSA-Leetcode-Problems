class Solution {
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int [][][]dp = new int[row+1][row+1][row+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                for(int k=0;k<dp.length;k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        
        for(int r1=row-1;r1>=0;r1--){
            for(int c1=row-1;c1>=0;c1--){
                for(int r2=row-1;r2>=0;r2--){
                    
                    int c2 = r1+c1-r2;
                    
                    if(c2<0 || c2>=row) continue;
                    
                    if(r1==row-1 && c1==row-1){
                        dp[row-1][row-1][row-1] = grid[row-1][row-1];
                        continue;
                    }
                    
                    if(grid[r1][c1]==-1 || grid[r2][c2]==-1){
                        dp[r1][c1][r2] = Integer.MIN_VALUE;
                        continue;
                    }
                    
                    int cherries = 0;
                    
                    if(r1==r2 && c1==c2) cherries+=grid[r1][c1];
                    else{
                        cherries += grid[r1][c1]+grid[r2][c2];
                    }
                    
                    cherries += Math.max(Math.max(dp[r1+1][c1][r2+1],dp[r1][c1+1][r2]),Math.max(dp[r1][c1+1][r2+1],dp[r1+1][c1][r2]));
                    
                    dp[r1][c1][r2] = cherries;
                }
            }
        }
        
        return Math.max(0,dp[0][0][0]);
        
        
        // int ans = cherryPickup(grid,0,0,0,dp);
        // ans = Math.max(0,ans);
        // return ans;
    }
    public int cherryPickup(int [][]grid,int r1,int c1,int r2,int [][][]dp){
        
        int c2 = r1+c1-r2;
        
        if(r1>=grid.length || r2>=grid.length || c1>=grid[0].length ||c2>=grid[0].length || grid[r1][c1]==-1 || grid[r2][c2]==-1) return Integer.MIN_VALUE;
        
        if(r1==grid.length-1 && c1==grid[0].length-1){
            return grid[r1][c1];
        }
    
        if(dp[r1][c1][r2]!=0) return dp[r1][c1][r2];
        
        int cherries = 0;
        
        if(r1==r2 && c1==c2) cherries+=grid[r1][c1];
        else{
            cherries += grid[r1][c1]+grid[r2][c2];
        }
        
        int hh = cherryPickup(grid,r1,c1+1,r2,dp);
        int vv = cherryPickup(grid,r1+1,c1,r2+1,dp);
        int hv = cherryPickup(grid,r1,c1+1,r2+1,dp);
        int vh = cherryPickup(grid,r1+1,c1,r2,dp);
        
        cherries += Math.max(Math.max(vv,hh),Math.max(vh,hv));
        
        // System.out.println("r1->"+r1+"c1->"+c1+"r2->"+r2+"c2->"+c2+"cherries->"+cherries);
        
        return dp[r1][c1][r2] = cherries;
    }
}