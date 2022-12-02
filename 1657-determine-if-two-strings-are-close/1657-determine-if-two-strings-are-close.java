class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        
        HashMap<Character,Integer> m1 = new HashMap<>();
        HashMap<Character,Integer> m2 = new HashMap<>();
        
        for(char ch : word1.toCharArray()){
            m1.put(ch,m1.getOrDefault(ch,0)+1);
        }
        for(char ch : word2.toCharArray()){
            m2.put(ch,m2.getOrDefault(ch,0)+1);
        }
        if(!m1.keySet().equals(m2.keySet())) return false;
        ArrayList<Integer> l1 = new ArrayList<>(m1.values());
        ArrayList<Integer> l2 = new ArrayList<>(m2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }
}