class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int maxlen = 0;
        while(i<s.length()){
            char ch;
            while(i<s.length() && map.getOrDefault(s.charAt(i),0)==0){
                ch=s.charAt(i);
                map.put(ch,1);
                i++;
                maxlen = Math.max(maxlen,i-j);
            }
            if(i<s.length()){
                ch=s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                while(j<i && map.getOrDefault(ch,0)!=1){
                    char lch = s.charAt(j);
                    if(map.getOrDefault(lch,0)>1){
                        map.put(lch,map.getOrDefault(lch,0)-1);
                    }else if(map.getOrDefault(lch,0)==1){
                        map.remove(lch);
                    }
                    j++;
                }
                i++;
            }
        }
        return maxlen;
    }
}