class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [][]dp = new int[n][n];
        
        for(int g=0;g<nums.length;g++){
            for(int i=0,j=g;j<nums.length;i++,j++){
               
                int min = Integer.MIN_VALUE;
                for(int k1=1,k2=g+1;k2>0;k1++,k2--){
                    int bottom = k1==g+1 ? 0 : dp[i+k1][j];
                    int left = k2==g+1 ? 0 : dp[i][j-k2];

                    int fac = (i-1<0 ? 1:nums[i-1] ) * (j+1<nums.length ? nums[j+1]:1) * nums[i+k1-1];

                    min = Math.max(fac+left+bottom,min);
                }
                dp[i][j] = min;
                
            }
        }
        return dp[0][n-1];
    }
}