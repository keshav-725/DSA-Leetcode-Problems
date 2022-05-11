class Solution {
    public int countVowelStrings(int n) {
        int []dp = new int[6];
        for(int i=0;i<=5;i++){
            dp[i]=i==5?0:1;
        }
        while(n>1){
            for(int i=4;i>=0;i--){
                dp[i]=dp[i]+dp[i+1];
            }
            n--;
        }
        int sum=0;
        for(int i=0;i<5;i++){
            sum += dp[i];
        }
        return sum;
    }
}