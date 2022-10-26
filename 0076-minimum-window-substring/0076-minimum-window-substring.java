class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        
        int count = t.length();
        int pcount = 0,ans=Integer.MAX_VALUE,j=0;
        String res = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(map2.getOrDefault(ch,0)>map1.getOrDefault(ch,0)) pcount++;
            
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            
            while(pcount == count){
                if(ans>(i-j+1)){
                    ans = i-j+1;
                    res = s.substring(j,i+1);
                }
                char jch = s.charAt(j);
                if(map2.getOrDefault(jch,0)>=map1.getOrDefault(jch,0)) pcount--;
                map1.put(jch,map1.get(jch)-1);
                j++;
            }
            
        }
        return res;
    }
}