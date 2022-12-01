class Solution {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet<>();
        
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        int lcount=0,rcount=0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(i<s.length()/2 && set.contains(ch)) lcount++;
            else if(i>=s.length()/2 && set.contains(ch)) rcount++;
        }
        
        return lcount==rcount;
    }
}