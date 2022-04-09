class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxlen = 0;
        int j=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1){
                char jch = s.charAt(j);
                map.put(jch,map.get(jch)-1);
                j++;
            }
            maxlen = Math.max(maxlen,i-j+1);
        }
        return maxlen;
    }
}