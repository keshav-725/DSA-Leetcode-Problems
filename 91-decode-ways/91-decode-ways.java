class Solution {
    public int numDecodings(String s) {
        int []dp = new int[s.length()];
        if(s.charAt(0)=='0') dp[0] = 0;
        else dp[0] = 1;
        
        for(int i=1;i<s.length();i++){
            int ich = s.charAt(i)-'0';
            int jch = s.charAt(i-1)-'0';
            
            if(ich==0 && jch==0){
                dp[i] = 0;
            }else if(ich==0){
                if(jch>=1 && jch<3){
                    dp[i] = (i>=2 ? dp[i-2] : 1);
                }else{
                    dp[i] = 0;
                }
            }else if(jch==0){
                dp[i] = dp[i-1];
            }else{
                if(jch*10 + ich<=26){
                    dp[i] = dp[i-1] + (i>=2 ? dp[i-2] : 1);
                }else{
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[s.length()-1];
    }
}