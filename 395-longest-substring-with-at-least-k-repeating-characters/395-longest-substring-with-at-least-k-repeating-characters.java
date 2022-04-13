class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(),0,s.length(),k);
    }
    int helper(char []ch,int start,int end,int k){
        if(end-start<k) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=start;i<end;i++){
            map.put(ch[i],map.getOrDefault(ch[i],0)+1);
        }
        //System.out.println(map);
        for(int i=start;i<end;i++){
            if(map.get(ch[i])<k){
                int j=i+1;
                while(j<end && map.get(ch[j])<k){
                    j++;
                }
                return Math.max(helper(ch,start,i,k),helper(ch,j,end,k));
            }
        }
        return end-start;
    }
}