class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        Integer [][]dp = new Integer[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                if(g==0){
                    int left = j-1<0 ? 1 : nums[j-1];
                    int right = j+1>=n ? 1 : nums[j+1];
                    dp[i][j] = left*right*nums[j];
                }else{
                    int max = Integer.MIN_VALUE;
                    for(int k1=g+1,k2=1;k1>=1;k1--,k2++){
                        int left = k1==g+1 ? 0 : dp[i][j-k1];
                        int bottom = k2==g+1 ? 0 : dp[i+k2][j];
                        int fac = (i<=0 ? 1 : nums[i-1])*nums[i+k2-1]*(j>=n-1 ? 1 : nums[j+1]);
                        
                        max = Math.max(max,left+bottom+fac);
                    }
                    dp[i][j] = max;
                }
            }
        }
        return dp[0][dp[0].length-1];
    }
}