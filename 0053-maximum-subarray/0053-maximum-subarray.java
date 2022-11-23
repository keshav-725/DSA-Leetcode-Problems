class Solution {
    public int maxSubArray(int[] nums) {
        Integer [][]dp = new Integer[2][nums.length];
        return helper(nums,0,false,dp);
        
    }
    public int helper(int []nums,int idx,boolean check,Integer [][]dp){
        if(idx==nums.length){
            if(check) return 0;
            return Integer.MIN_VALUE;
        }
        if(check){
            if(dp[1][idx]!=null) return dp[1][idx];
            return dp[1][idx]=Math.max(0,nums[idx]+helper(nums,idx+1,true,dp));
        }
        if(dp[0][idx]!=null) return dp[0][idx];
        return dp[0][idx]=Math.max(helper(nums,idx+1,false,dp),nums[idx]+helper(nums,idx+1,true,dp));
    }
}