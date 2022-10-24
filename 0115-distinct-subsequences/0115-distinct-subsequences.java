class Solution {
    int count;
    public int numDistinct(String s, String t) {
        count = 0;
        Integer [][]dp = new Integer[s.length()][t.length()];
        return helper(s,t,0,0,"",dp);
        // return count;
    }
    public int helper(String s,String t,int si,int ti,String check,Integer [][]dp){
        if(si==s.length() || ti==t.length()){
            if(t.equals(check)) return 1;
            return 0;
        }
        if(dp[si][ti] != null) return dp[si][ti];
        char sch = s.charAt(si);
        char tch = t.charAt(ti);
        int l = 0;
        if(sch==tch){
            l = helper(s,t,si+1,ti+1,check+sch,dp);
        }
        int r = helper(s,t,si+1,ti,check,dp);
        return dp[si][ti]=l+r;
    }
}