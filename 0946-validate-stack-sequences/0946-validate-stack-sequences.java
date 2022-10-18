class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i=0,j=0;
        while(i<pushed.length){
            st.push(pushed[i]);
            
            while(j<pushed.length && st.size()>0 && st.peek()==popped[j]){
                st.pop();
                j++;
            }
            i++;
        }
        return st.size()==0;
    }
}