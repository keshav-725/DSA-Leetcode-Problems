class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        
        if(t.length()>s.length()) return "";
        
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        int count = t.length();
        int potcount = 0;
        for(int i=0;i<t.length();i++){
            char ch = s.charAt(i);
            if(map1.containsKey(ch) && map1.get(ch)>map2.getOrDefault(ch,0)){
                potcount++;
            }
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int i = t.length();
        int j = 0;
        String ans = "";
        int minlen = Integer.MAX_VALUE;
        if(potcount==count){
            return s.substring(j,i);
        }
        while(i<s.length()){
            char ch = s.charAt(i);
            if(map1.containsKey(ch) && map1.get(ch)>map2.getOrDefault(ch,0)){
                potcount++;
            }
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            while(potcount==count){
                if(minlen>i-j){
                    ans = s.substring(j,i+1);
                    minlen = i-j+1;
                }
                char prevch = s.charAt(j);
                if(map1.containsKey(prevch) && map2.get(prevch)<=map1.get(prevch)){
                    potcount--;
                }
                map2.put(prevch,map2.get(prevch)-1);
                j++;
            }
            i++;
        }
        return ans;
    }
}