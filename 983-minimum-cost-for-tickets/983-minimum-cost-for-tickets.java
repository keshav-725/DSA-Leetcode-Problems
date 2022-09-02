class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int lday = days[n-1];
        int []dp = new int[lday+1];
        int j=0;
        for(int i=1;i<dp.length;i++){
            if(days[j]==i){
                int min = Integer.MAX_VALUE;
                for(int k=0;k<costs.length;k++){
                    if(k==0){
                        int pday = i-1;
                        min = Math.min(min,dp[pday]+costs[k]);
                    }else if(k==1){
                        int pday = i-6;
                        if(pday<=0) min = Math.min(min,costs[k]);
                        else min = Math.min(min,dp[pday-1]+costs[k]);
                    }else{
                        int pday = i-29;
                        if(pday<=0) min = Math.min(min,costs[k]);
                        else{
                            min = Math.min(min,dp[pday-1]+costs[k]);
                        }
                    }
                }
                dp[i] = min;
                j++;
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[lday];
    }
}