class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else{
                if(st.size()==0) return false;
                else if(ch==')' && st.peek()!='(') return false;
                else if(ch=='}' && st.peek()!='{') return false;
                else if(ch==']' && st.peek()!='[') return false;
                st.pop();
            }
        }
        return st.size()==0;
    }
}