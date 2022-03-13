class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push('(');
            }else if(s.charAt(i)==')'){
                if(st.size()==0) return false;
                if(st.peek()=='('){
                    st.pop();
                }
                else{
                    return false;
                }
            }else if(s.charAt(i)=='{'){
                st.push('{');
            }else if(s.charAt(i)=='}'){
                if(st.size()==0) return false;
                if(st.peek()=='{'){
                    st.pop();
                }
                else{
                    return false;
                }
            }else if(s.charAt(i)=='['){
                st.push('[');
            }else if(s.charAt(i)==']'){
                if(st.size()==0) return false;
                if(st.peek()=='['){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(st.size()>0){
            return false;
        }
        return true;
    }
}