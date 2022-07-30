class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int [][]dp = new int[len][len];
        
        for(int g=0;g<len;g++){
            for(int i=0,j=g;j<len;i++,j++){
                if(g==0){
                    dp[i][j]=1;
                }else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=1;
                    }
                }
                else{
                    if(dp[i+1][j-1]==1 && s.charAt(i)==s.charAt(j)) dp[i][j]=1;
                }
            }
        }
        int count = 0;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(dp[i][j]==1) count++;
            }
        }
        return count;
    }
}