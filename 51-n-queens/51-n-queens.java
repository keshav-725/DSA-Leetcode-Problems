class Solution {
    int[][] grid;
    List<List<String>> ans = new ArrayList();
    
    public List<List<String>> solveNQueens(int n) {
        grid = new int[n][n];
        helper(n, 0);
        
        return ans;
    }
    
    public void helper(int n, int row) {
        if(row == n) {
            List<String> list = new ArrayList();
            
            for(int i=0; i<n; ++i) {
                StringBuilder str = new StringBuilder();
                
                for(int j=0; j<n; ++j) {
                    if(grid[i][j] == 1)
                        str.append("Q");
                    
                    else
                        str.append(".");
                }
                
                list.add(str.toString());
            }

            ans.add(list);
            return;
        }
        
        for(int col=0; col<n; ++col) {
            boolean leftTop = checkDiagonal(row, col, 0, n);
            boolean rightTop = checkDiagonal(row, col, 1, n);
            boolean leftBottom = checkDiagonal(row, col, 2, n);
            boolean rightBottom = checkDiagonal(row, col, 3, n);
 
            if(!leftTop && !rightTop && !leftBottom && !rightBottom && !checkCol(col, n)) {
                grid[row][col] = 1;
                helper(n, row+1);
                grid[row][col] = 0;
            }
        }
    }
    
    public boolean checkDiagonal(int i, int j, int mode, int n) {
        int[][] move = new int[][] {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        while(i >= 0 && i < n && j >= 0 && j < n) {
            if(grid[i][j] == 1)
                return true;

            i += move[mode][1];
            j += move[mode][0];            
        }
        
        return false;
    }
    
    public boolean checkCol(int col, int n) {
        for(int row=0; row<n; ++row) {
            if(grid[row][col] == 1)
                return true;
        }
        
        return false;
    }
}