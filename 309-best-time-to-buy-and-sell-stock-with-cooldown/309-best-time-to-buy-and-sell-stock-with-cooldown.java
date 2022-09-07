class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][]dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i=1;i<n;i++){
            if(i>=2){
                dp[i][0] = Math.max(dp[i-2][1]-prices[i],dp[i-1][0]);
            }else{
                dp[i][0] = Math.max(-prices[i],-prices[i-1]);
            }
            dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        // for(int i=0;i<n;i++){
        //     System.out.println("---------------");
        //     System.out.println(dp[i][0]);
        //     System.out.println(dp[i][1]);
        // }
        return dp[n-1][1];
    }
}