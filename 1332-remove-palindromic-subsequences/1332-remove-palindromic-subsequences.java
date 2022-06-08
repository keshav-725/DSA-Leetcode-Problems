class Solution {
    public int removePalindromeSub(String s) {
        int i=0,j=s.length()-1;
        while(i<=j){
            char ch=s.charAt(i);
            char jch = s.charAt(j);
            if(ch!=jch){
                return 2;
            }
            i++;
            j--;
        }
        return 1;
        
    }
}