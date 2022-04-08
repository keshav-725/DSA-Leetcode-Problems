class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<HashMap<Character,Integer>,ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            HashMap<Character,Integer> inmap = new HashMap<>();
            for(int j=0;j<str.length();j++){
                char ch = str.charAt(j);
                inmap.put(ch,inmap.getOrDefault(ch,0)+1);
            }
            if(!map.containsKey(inmap)){
                map.put(inmap,new ArrayList<>());
            }
            map.get(inmap).add(str);
        }
        for(HashMap<Character,Integer> tempmap : map.keySet()){
            ans.add(map.get(tempmap));
        }
        return ans;
    }
}