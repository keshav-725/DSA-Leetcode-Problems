class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        int j=0,i=0;
        for(;i<t.length();i++){
            char t1 = t.charAt(i);
            char s1 = s.charAt(j);
            if(t1==s1){
                j++;
                if(j==s.length()) break;
            }
        }
        if(i==t.length() && j<s.length()){
            return false;
        }
        return true;
    }
}