class Solution {
    public int countVowelPermutation(int n) {
        long [][]dp = new long[n+1][5];
        for(int i=0;i<5;i++){
            dp[1][i] = 1;
        }
        int m = 1000000007;
        for(int i=2;i<=n;i++){
            for(int j=0;j<5;j++){
                if(j==0){
                    dp[i][0] = (dp[i-1][1]+dp[i-1][2]+(dp[i-1][4]%m))%m;
                }else if(j==1){
                    dp[i][1] = (dp[i-1][0] + dp[i-1][2])%m;
                }else if(j==2){
                    dp[i][2] = (dp[i-1][1] + dp[i-1][3])%m;
                }else if(j==3){
                    dp[i][3] = dp[i-1][2]%m;
                }else{
                    dp[i][4] = (dp[i-1][2] + dp[i-1][3])%m;
                }
            }
        }
        long count = 0;
        for(int i=0;i<5;i++){
            count = ((count%m) + (dp[n][i]%m))%m;
        }
        return (int)count;
    }
}