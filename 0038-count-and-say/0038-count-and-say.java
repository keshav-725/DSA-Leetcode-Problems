class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String temp = countAndSay(n-1);
        StringBuilder sb = new StringBuilder("");
        int i=0;
        while(i<temp.length()){
            char ch = temp.charAt(i);
            int count = 0;
            while(i<temp.length() && temp.charAt(i)==ch){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(ch);
        }
        return sb.toString();
    }
}