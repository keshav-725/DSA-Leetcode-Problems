class Solution {
    public int climbStairs(int n) {
        Integer []dp = new Integer[n+1];
        return fn(n,dp);
    }
    public int fn(int n,Integer []dp){
        if(n==0) return 1;
        if(n==1) return 1;
        if(dp[n]!=null) return dp[n];
        int val = fn(n-1,dp) + fn(n-2,dp);
        dp[n] = val;
        return val;
    }
}