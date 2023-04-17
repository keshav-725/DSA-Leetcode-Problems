class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<HashMap<Character,Integer>,List<String>> map = new HashMap<>();
        for(String s : strs){
            HashMap<Character,Integer> tmap = new HashMap<>();
            for(char ch : s.toCharArray()){
                tmap.put(ch,tmap.getOrDefault(ch,0)+1);
            }
            map.putIfAbsent(tmap,new ArrayList<>());
            map.get(tmap).add(s);
        }
        for(HashMap<Character,Integer> tmap : map.keySet()){
            ans.add(map.get(tmap));
        }
        return ans;
    }
}