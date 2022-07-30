class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        
        int [][]dp = new int[len1+1][len2+1];
        
        for(int i=len1;i>=0;i--){
            for(int j=len2;j>=0;j--){
                if(i==len1 || j==len2) dp[i][j] = 0;
                else{
                    if(text1.charAt(i)==text2.charAt(j)){
                        dp[i][j] = dp[i+1][j+1]+1;
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}