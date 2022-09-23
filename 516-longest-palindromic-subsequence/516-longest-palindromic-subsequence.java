class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        Integer [][]dp = new Integer[n][n];
        return longestPalindromeSubseq(s,0,s.length()-1,dp);
    }
    public int longestPalindromeSubseq(String s,int i,int j,Integer [][]dp){
        if(i>j) return 0;
        if(i==j) return 1;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=2+longestPalindromeSubseq(s,i+1,j-1,dp);
        }else{
            return dp[i][j]=Math.max(longestPalindromeSubseq(s,i+1,j,dp),longestPalindromeSubseq(s,i,j-1,dp));
        }
        
    }
}