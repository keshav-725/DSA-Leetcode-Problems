class Solution {
    public int jump(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0,nums,dp);
    }
    public int helper(int idx,int []nums,int []dp){
        if(idx==(nums.length-1)) return 0;
        int mval = 1000000009;
        if(dp[idx]!=-1) return dp[idx];
        for(int i=1;i<=nums[idx];i++){
            if((idx+i)<=(nums.length-1)){
                int ans = 1+helper(idx+i,nums,dp);
                mval = Math.min(mval,ans);
            }
        }
        return dp[idx]=mval;
    }
}