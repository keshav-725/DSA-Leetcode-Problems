class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int [][]dp = new int[row][col];
        int max = 0;
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(i+1<row && j+1<col && matrix[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i+1][j+1],Math.min(dp[i+1][j],dp[i][j+1]))+1;   
                }
                else{
                    dp[i][j]=matrix[i][j]-'0';
                }
                max = Math.max(dp[i][j],max);
            }
        }
        return max*max;
    }
}