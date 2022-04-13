class Solution {
   public boolean queryString(String S, int N) {
        for(int i = N; i >= N/2; i--) {
            String digits = toBinary(i);
            if(!S.contains(digits)) return false;
        }
        return true;
    }
    
    private String toBinary(int x) {
        String s = "";
        while(x > 0) {
            s += (x % 2);
            x /= 2;
        }
        String str = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            str += s.charAt(i);
        }
        return str;
    }
}