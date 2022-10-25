class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];
            HashMap<Character,Integer> tmap = new HashMap<>();
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                tmap.put(ch,tmap.getOrDefault(ch,0)+1);
            }
            map.putIfAbsent(tmap,new ArrayList<>());
            map.get(tmap).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(HashMap<Character,Integer> key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}