class Solution {
    public int lengthOfLIS(int[] nums) {
        int []dp = new int[nums.length];
        int max = 0;
        for(int i=0;i<nums.length;i++){
            int val=0,j=i-1;
            while(j>=0){
                if(nums[j]<nums[i]){
                    val=Math.max(val,dp[j]);
                }
                j--;
            }
            dp[i]=val+1;
            max = Math.max(dp[i],max);
        }
        // for(int i=0;i<nums.length;i++){
        //     System.out.println(dp[i]);
        // }
        return max;
    }
}