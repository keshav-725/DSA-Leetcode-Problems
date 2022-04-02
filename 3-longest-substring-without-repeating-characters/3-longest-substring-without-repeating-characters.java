class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        int maxlen = 0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(i<s.length() && !set.contains(ch)){
                set.add(ch);
                maxlen = Math.max(maxlen,i-j+1);
                i++;
            }else{
                if(j<i){
                    set.remove(s.charAt(j));
                    j++;
                }
            }
        }
        return maxlen;
    }
}