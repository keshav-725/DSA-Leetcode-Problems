class Solution {
    public String reverseWords(String str) {
        String []breaks = str.split(" ");
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<breaks.length;i++){
            String tempstr = reverseString(breaks[i]);
            sb.append(tempstr+" ");
        }
        sb.deleteCharAt(str.length());
        return sb.toString();
    }
    public String reverseString(String s) {
        int i=0;
        int j=s.length()-1;
        char []temparr = s.toCharArray();
        while(i<j){
            char temp = temparr[i];
            temparr[i] = temparr[j];
            temparr[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(temparr);
    }
}