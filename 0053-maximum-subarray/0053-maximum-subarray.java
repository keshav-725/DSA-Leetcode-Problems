class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        dp[0] = nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
            int max = nums[i];
            max = Math.max(max,nums[i]+dp[i-1]);
            dp[i] = max;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}