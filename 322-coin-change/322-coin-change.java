class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer []dp = new Integer[amount+1];
        dp[0] = 0;
        for(int i=0;i<coins.length;i++){
            int coin = coins[i];
            for(int j=1;j<dp.length;j++){
                if(j-coin>=0){
                    if(dp[j-coin]!=null){
                        if(dp[j]==null) dp[j]=dp[j-coin]+1;
                        else dp[j]=Math.min(dp[j],dp[j-coin]+1);
                    }
                }
            }
        }
        return dp[amount]==null?-1:dp[amount];
    }
}