class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int lvp = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(i);
            }else{
                if(st.size()>1 && s.charAt(st.peek())=='('){
                    st.pop();
                    lvp = Math.max(lvp,i-st.peek());
                }else{
                    st.push(i);
                }
            }
        }
        return lvp;
    }
}