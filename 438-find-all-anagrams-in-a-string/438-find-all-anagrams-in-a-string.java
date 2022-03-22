class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if(p.length()>s.length()){
            return list;
        }
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> map2 = new HashMap<>();
        int j=0;
        for(int i=0;i<p.length();i++){
            char ch = s.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        if(map1.equals(map2)){
            list.add(j);
        }
        for(int i=p.length();i<s.length();i++){
            char ch = s.charAt(i);
            char prevch = s.charAt(j);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if(map2.get(prevch)>1){
                map2.put(prevch,map2.get(prevch)-1);
            }else if(map2.get(prevch)==1){
                map2.remove(prevch);
            }
            j++;
            if(map1.equals(map2)){
                list.add(j);
            }
        }
        return list;
    }
}