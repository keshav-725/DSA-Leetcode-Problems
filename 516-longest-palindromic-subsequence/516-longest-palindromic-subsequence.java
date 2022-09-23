class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][]dp = new int[n][n];
        // return longestPalindromeSubseq(s,0,s.length()-1,dp);
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;j++,i++){
                if(g==0){
                    dp[i][j] = 1;
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = 2+dp[i+1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][n-1];
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