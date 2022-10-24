class Solution {
    public boolean isMatch(String s, String p) {
        Integer [][]dp = new Integer[s.length()][p.length()];
        return helper(s,p,0,0,dp);
    }
    public boolean helper(String s,String p,int si,int pi,Integer[][] dp){
        if(si == s.length() || pi==p.length()){
            if(pi==p.length() && si==s.length()) return true;
            else if(pi==p.length() && si<s.length()) return false;
            else{
                for(int k=pi;k<p.length();k++){
                    if(p.charAt(k)!='*') return false;
                }
                return true;
            }
        }
        if(dp[si][pi] != null){
            return dp[si][pi] == 1? true : false;
        }
        // System.out.println("si"+si+"pi"+pi);
        char sch = s.charAt(si);
        char pch = p.charAt(pi);
        boolean check;
        if(sch == pch){
            check = helper(s,p,si+1,pi+1,dp);
        }else{
            if(pch=='*'){
                check = (helper(s,p,si+1,pi,dp) || helper(s,p,si,pi+1,dp));
            }else if(pch=='?'){
                check = helper(s,p,si+1,pi+1,dp);
            }else{
                check = false;
            }
        }
        if(check==false){
            dp[si][pi] = 0;
            return false;
        }
        dp[si][pi] = 1;
        return true;
    }
}