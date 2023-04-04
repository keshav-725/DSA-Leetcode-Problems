class Solution {
    public int partitionString(String s) {
        int count = 1 ;
        HashSet<Character> set = new HashSet<>();
        for(int i =0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                set.clear();
                set.add(s.charAt(i));
                count++;
            }
            else {
                set.add(s.charAt(i));
            }
        }
        return count ;
    }
}