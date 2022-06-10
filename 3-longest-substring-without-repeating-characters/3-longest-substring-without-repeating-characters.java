class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j=0,max=0,total=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.containsKey(ch) && map.get(ch)>1){
                while(map.containsKey(ch) && map.get(ch)>1){
                    char jch = s.charAt(j);
                    map.put(jch,map.get(jch)-1);
                    if(map.get(jch)<=0){
                        map.remove(jch);   
                    }
                    j++;
                    max--;
                }
            }
            max++;
            total=Math.max(total,max);
        }
        return total;
    }
}