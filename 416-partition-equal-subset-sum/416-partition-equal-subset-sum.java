class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums){
            sum += val;
        }
        if(sum%2!=0) return false;
        sum = sum/2;
        int n = nums.length;
        boolean [][]dp = new boolean[n+1][sum+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0) dp[i][j] = true;
                else if(i==0){
                    dp[i][j] = false;
                }else if(j==0){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i-1][j];
                    if(dp[i][j]==false){
                        int curr = nums[i-1];
                        if(j>=curr){
                            dp[i][j] = dp[i-1][j-curr];
                        }
                    }
                }
            }
        }
        return dp[n][sum];
    }
}