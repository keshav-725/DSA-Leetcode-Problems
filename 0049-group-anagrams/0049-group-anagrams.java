class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char []sarr = s.toCharArray();
            Arrays.sort(sarr);
            String nstr = new String(sarr);
            
            map.putIfAbsent(nstr,new ArrayList<>());
            map.get(nstr).add(s);
        }
        for(String tmap : map.keySet()){
            ans.add(map.get(tmap));
        }
        return ans;
    }
}