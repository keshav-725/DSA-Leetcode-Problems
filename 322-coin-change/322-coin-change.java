class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer []dp = new Integer[amount+1];
        dp[0]=0;
        for(int i=0;i<coins.length;i++){
            int num = coins[i];
            for(int j=num;j<dp.length;j++){
                if(dp[j]!=null && dp[j-num]!=null){
                    dp[j]=Math.min(dp[j],dp[j-num]+1);
                }else if(dp[j-num]!=null){
                    dp[j]=dp[j-num]+1;
                }
            }
        }
        // for(int i=0;i<dp.length;i++){
        //     System.out.println(dp[i]);
        // }
        return dp[amount]==null?-1:dp[amount];
    }
}