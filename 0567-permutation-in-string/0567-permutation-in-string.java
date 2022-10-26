class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        int []map1 = new int[26];
        int []map2 = new int[26];
        
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            map1[ch-'a']++;
        }
        int j=0;
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            map2[ch-'a']++;
            
            if((i-j+1)>s1.length()){
                map2[s2.charAt(j)-'a']--;
                j++;
            }
            
            if(isEqual(map1,map2)) return true;
        }
        return false;
    }
    public boolean isEqual(int []map1,int []map2){
        
        for(int i=0;i<26;i++){
            if(map1[i]!=map2[i]) return false;
        }
        return true;
    }
}