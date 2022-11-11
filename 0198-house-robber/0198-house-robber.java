class Solution {
    public int rob(int[] nums) {
        int []dp = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            if(i==0){
                dp[0] = nums[0];
            }else if(i==1){
                dp[1] = Math.max(nums[0],nums[1]);
            }else{
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
        }
        return dp[nums.length-1];
    }
}