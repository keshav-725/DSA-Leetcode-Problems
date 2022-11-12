class Solution {
    public int numSquares(int n) {
        int []dp = new int[n+1];
        dp[1] = 1;
        
        for(int i=2;i<=n;i++){
            int min = i;
            for(int j=1;j*j<=i;j++){
                min = Math.min(dp[i-j*j],min);
            }
            min++;
            dp[i] = min;
        }
        
        return dp[n];
    }
}