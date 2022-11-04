class Solution {
    public String reverseVowels(String s) {
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

        int start =0;
        int end =s.length()-1;
        char[] c = s.toCharArray();
        while(start < end){
            if(!set.contains(c[start])){
                start++;
            }
            if(!set.contains(c[end])){
                end--;
            }
            else if(set.contains(c[start]) && set.contains(c[end])){
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;
            }
        }
        return new String(c);
    }
}