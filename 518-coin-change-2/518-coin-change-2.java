class Solution {
    public int change(int amount, int[] coins) {
        int []dp = new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            int coin = coins[i];
            for(int j=0;j<dp.length;j++){
                if(j>=coin){
                    dp[j] += dp[j-coin];
                }
            }
        }
        return dp[amount];
    }
}