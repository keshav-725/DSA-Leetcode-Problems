class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        int [][]dp = new int[n+1][m+1];
        for(int []arr : dp){
            Arrays.fill(arr,-1);
        }
        return helper(word1,word2,n,m,dp);
    }
    public int helper(String word1,String word2,int n,int m,int [][]dp){
        if(dp[n][m]!=-1) return dp[n][m];
        if(n==0){
            dp[n][m]=m;
            return m;
        }
        if(m==0){
            dp[n][m]=n;
            return n;
        }
        if(word1.charAt(n-1)==word2.charAt(m-1)){
            return dp[n][m]=helper(word1,word2,n-1,m-1,dp);
        }else{
            int insert = helper(word1,word2,n,m-1,dp);
            int delete = helper(word1,word2,n-1,m,dp);
            int replace = helper(word1,word2,n-1,m-1,dp);
            int min = Math.min(insert,Math.min(delete,replace));
            return dp[n][m]=1+min;
        }
    }
}