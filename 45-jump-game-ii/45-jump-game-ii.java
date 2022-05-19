class Solution {
    public int jump(int[] nums) {
        int i=nums.length-2;
        int []dp = new int[nums.length];
        dp[dp.length-1] = 0;
        for(;i>=0;i--){
            int min = Integer.MAX_VALUE;
            for(int j=1;j+i<nums.length && j<=nums[i];j++){
                min = Math.min(min,dp[j+i]);
            }
            if(min!=Integer.MAX_VALUE){
                dp[i] = min+1;
            }else{
                dp[i] = min;
            }
        }
        // for(i=0;i<dp.length;i++){
        //     System.out.println(dp[i]);
        // }
        return dp[0];
    }
}