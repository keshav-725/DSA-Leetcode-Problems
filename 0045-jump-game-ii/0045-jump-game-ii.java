class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]==0) continue;
            else{
                int min = Integer.MAX_VALUE;
                for(int j=1;j<=nums[i] && i+j<n;j++){
                    if(dp[i+j]!=-1){
                        min = Math.min(min,dp[i+j]);
                    }
                }
                dp[i] = min==Integer.MAX_VALUE ? -1 : min+1;
            }
        }
        
        return dp[0];
    }
}