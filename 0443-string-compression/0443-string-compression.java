class Solution {
    public int compress(char[] ch) {
        StringBuilder sb = new StringBuilder();
       int count=1;
       for(int i=0;i<ch.length-1;i++){
           if(ch[i]==ch[i+1]) count++;
           else{
               sb.append(ch[i]);
               if(count>1) sb.append(count);
               count=1;
           }
        }
        sb.append(ch[ch.length-1]);
        if(count>1)sb.append(count); 
        if(sb.length()>ch.length) return ch.length;
        for(int i=0;i<sb.length();i++){
            ch[i]=sb.charAt(i);
        }
        return sb.length();
    }
}