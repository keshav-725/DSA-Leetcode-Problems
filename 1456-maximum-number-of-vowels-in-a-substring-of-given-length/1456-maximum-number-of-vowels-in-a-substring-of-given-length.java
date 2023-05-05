class Solution {
    public int maxVowels(String s, int k) {
        int max = 0,j=0,res=0;
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(set.contains(ch)) res++;
            if(i-j+1>k){
                char jch = s.charAt(j);
                if(set.contains(jch)) res--;
                j++;
            }
            max = Math.max(res,max);
        }
        return max;
    }
}