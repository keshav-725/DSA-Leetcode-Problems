class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer [][]dp = new Integer[text1.length()][text2.length()];
        return longestCommonSubsequence(text1,text2,text1.length()-1,text2.length()-1,dp);
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