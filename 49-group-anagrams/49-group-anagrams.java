class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<HashMap<Character,Integer>,ArrayList<String>> map = new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            HashMap<Character,Integer> charcountmap = new HashMap<>();
            for(int j=0;j<strs[i].length();j++){
                char ch = strs[i].charAt(j);
                charcountmap.put(ch,charcountmap.getOrDefault(ch,0)+1);
            }
            if(map.containsKey(charcountmap)){
                map.get(charcountmap).add(strs[i]);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(charcountmap,list);
            }
        }
        for(HashMap<Character,Integer> tempmap : map.keySet()){
            res.add(map.get(tempmap));
        }
        return res;
    }
}