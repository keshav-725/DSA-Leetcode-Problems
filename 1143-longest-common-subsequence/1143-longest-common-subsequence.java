class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp = new int[text1.length()+1][text2.length()+1];
        // return longestCommonSubsequence(text1,text2,text1.length()-1,text2.length()-1,dp);
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public int longestCommonSubsequence(String t1,String t2,int i,int j,Integer [][]dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(t1.charAt(i)==t2.charAt(j)){
            return dp[i][j]=1+longestCommonSubsequence(t1,t2,i-1,j-1,dp);
        }else{
            return dp[i][j]=Math.max(longestCommonSubsequence(t1,t2,i-1,j,dp),longestCommonSubsequence(t1,t2,i,j-1,dp));
        }
    }
}