class Solution {
    int ans;
    public int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        helper(0,nums,target,0);
        return ans;
    }
    public void helper(int idx,int[] nums,int target,int sum){
        if(idx==nums.length){
            if(sum==target) ans++;
            return;
        }
        helper(idx+1,nums,target,sum+nums[idx]);
        helper(idx+1,nums,target,sum-nums[idx]);
    }
}