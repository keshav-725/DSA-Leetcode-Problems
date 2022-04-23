class Solution {
   public int deleteAndEarn(int[] nums) {
      int l=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<l;i++)
        {
            if(nums[i]>max)
                max=nums[i];
            
            
        }
        int a[]=new int[max+1];
        for(int j=0;j<l;j++)
        {
            a[nums[j]]+=nums[j];
        }
       // System.out.println(Arrays.toString(a)+" "+max);
        int dp[]=new int[max+1];
        dp[0]=a[0];
        dp[1]=a[0]>=a[1]?a[0]:a[1];
        for(int k=2;k<=max;k++)
        {
            dp[k]=Math.max(dp[k-1],dp[k-2]+a[k]);
        }
        return dp[max];
        
        
        
    }
}