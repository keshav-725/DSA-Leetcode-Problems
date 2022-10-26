class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int j=0,ans=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            while(j<i && map.get(ch)>1){
                char jch = s.charAt(j);
                map.put(jch,map.get(jch)-1);
                if(map.get(jch)==0) map.remove(jch);
                j++;
            }
            ans = Math.max(ans,map.size());
        }
        return ans;
    }
}