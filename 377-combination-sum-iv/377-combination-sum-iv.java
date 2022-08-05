class Solution {
    int ans;
    public int combinationSum4(int[] nums, int target) {
        Integer []dp= new Integer[target+1];
        ans = 0;
        for(int i=0;i<nums.length;i++){
            ans += helper(i,dp,nums,target-nums[i]);
        }
        return ans;
    }
    public int helper(int idx,Integer []dp,int []nums,int target){
        if(target<0) return 0;
        if(target==0){
            return 1;
        }
        if(dp[target]!=null) return dp[target];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count += helper(i,dp,nums,target-nums[i]);
        }
        dp[target] = count;
        return count;
    }
    
}