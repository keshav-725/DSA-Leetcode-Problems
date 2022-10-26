class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int j = 0,ans=Integer.MAX_VALUE;
        String res = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            while(isExist(map1,map2)){
                // System.out.println("i-> "+i);
                // System.out.println(map1);
                if(ans>(i-j+1)){
                    ans = i-j+1;
                    res = s.substring(j,i+1);
                }
                char jch = s.charAt(j);
                j++;
                map1.put(jch,map1.get(jch)-1);
                if(map1.get(jch)==0) map1.remove(jch);
            }
        }
        return res;
    }
    public boolean isExist(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
        
        for(char ch : map2.keySet()){
            if(map1.containsKey(ch) && map1.get(ch)>=map2.get(ch)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}