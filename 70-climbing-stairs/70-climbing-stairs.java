class Solution {
    public int climbStairs(int n) {
        int []dp = new int[n+1];
        dp[dp.length-1]=1;
        dp[dp.length-2]=1;
        for(int i=dp.length-3;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];
    }
}