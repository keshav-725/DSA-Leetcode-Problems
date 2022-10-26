class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxCount=0,j=0,ans=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            maxCount = Math.max(maxCount,map.get(ch));
            
            while((i-j+1-maxCount)>k){
                char jch = s.charAt(j);
                map.put(jch,map.get(jch)-1);
                j++;
            }
            ans = Math.max(ans,(i-j+1));
        }
        return ans;
    }
}