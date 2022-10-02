class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        Integer [][]dp = new Integer[n+1][target+1];
        return helper(n,k,target,dp);
    }
    public int helper(int n,int k,int target,Integer [][]dp){
        if(target<0) return 0;
        if(n==0){
            if(target==0) return 1;
            else return 0;
        }
        int mod = 1000000007;
        if(dp[n][target]!=null) return dp[n][target];
        int sum=0;
        for(int i=1;i<=k;i++){
            sum = ((sum%mod)+(helper(n-1,k,target-i,dp)%mod)%mod);
        }
        dp[n][target]=sum%mod;
        return sum%mod;
    }
}