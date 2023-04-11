class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='*'){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        while(st.size()>0){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}