class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans="";
        int maxlen=0;
        int [][]dp = new int[n][n];
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;i++,j++){
                char ich = s.charAt(i);
                char jch = s.charAt(j);
                
                if(g==0){
                    dp[i][j]=1;
                }else if(g==1){
                    if(ich==jch){
                        dp[i][j]=1;
                    }
                }else{
                    if(ich==jch && dp[i+1][j-1]==1){
                        dp[i][j]=1;
                    }
                }
                if(dp[i][j]==1 && maxlen<g+1){
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}