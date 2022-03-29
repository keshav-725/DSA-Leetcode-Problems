class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                char check = map.get(ch);
                if(check!=t.charAt(i)) return false;
            }else{
                if(map.containsValue(t.charAt(i))) return false;
                map.put(ch,t.charAt(i));
            }
        }
        return true;
    }
}