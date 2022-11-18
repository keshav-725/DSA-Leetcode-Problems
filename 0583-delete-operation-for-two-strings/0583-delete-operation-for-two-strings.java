class Solution {
    public int minDistance(String word1, String word2) {
        Integer [][]dp = new Integer[word1.length()][word2.length()];
        return helper(word1,word2,0,0,dp);
    }
    public int helper(String w1,String w2,int i1,int i2,Integer [][]dp){
        
        if(i1==w1.length() || i2==w2.length()){
            if(i1==w1.length() && i2==w2.length()){
                return 0;
            }else if(i1==w1.length()){
                return w2.length()-i2;
            }else{
                return w1.length()-i1;
            }
        }
        if(dp[i1][i2]!=null) return dp[i1][i2];
        if(w1.charAt(i1)==w2.charAt(i2)){
            return dp[i1][i2]=helper(w1,w2,i1+1,i2+1,dp);
        }else{
            return dp[i1][i2]=Math.min(helper(w1,w2,i1+1,i2,dp),helper(w1,w2,i1,i2+1,dp))+1;
        }
    }
}