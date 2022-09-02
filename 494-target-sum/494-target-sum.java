class Solution {
    int ans;
    public int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        // int [][]dp = new int[nums.length][target];
        helper(0,nums,target);
        return ans;
    }
    public void helper(int idx,int[] nums,int target){
        if(idx==nums.length){
            if(target==0) ans++;
            return;
        }
        helper(idx+1,nums,target-nums[idx]);
        helper(idx+1,nums,target+nums[idx]);
    }
}