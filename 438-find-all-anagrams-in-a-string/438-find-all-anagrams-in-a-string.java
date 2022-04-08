class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int []map1 = new int[26];
        List<Integer> list = new ArrayList<>();
        if(p.length()>s.length()) return list;
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            map1[ch-'a']++;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            count += map1[i];
        }
        int []map2 = new int[26];
        for(int i=0;i<p.length();i++){
            char ch = s.charAt(i);
            map2[ch-'a']++;
        }
        int j=0;
        int i = p.length();
        if(areAnagram(map1,map2)){
            list.add(j);
        }
        for(;i<s.length();i++){
            char ch = s.charAt(i);
            char prevch = s.charAt(j);
            map2[ch-'a']++;
            map2[prevch-'a']--;
            j++;
            if(areAnagram(map1,map2)){
                list.add(j);
            }
        }
        return list;
    }
    public boolean areAnagram(int []map1,int []map2){
        for(int i=0;i<26;i++){
            if(map1[i]!=map2[i]) return false;
        }
        return true;
    }
}