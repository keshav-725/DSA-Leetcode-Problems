class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int maxlen = 0;
        while(i<s.length()){
            if(i<s.length() && map.getOrDefault(s.charAt(i),0)==0){
                map.put(s.charAt(i),1);
                i++;
                maxlen = Math.max(maxlen,i-j);
            }else{
                if(j<i){
                    map.put(s.charAt(j),map.get(s.charAt(j))-1);
                    j++;
                }
            }
        }
        return maxlen;
    }
}