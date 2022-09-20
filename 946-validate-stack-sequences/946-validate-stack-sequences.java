class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i=0,j=0;
        while(i<pushed.length){
            
            while(i<pushed.length && popped[j]!=pushed[i]){
                st.push(pushed[i]);
                i++;
            }
            if(i<pushed.length) st.push(pushed[i]);
            i++;
            
            while(st.size()>0 && j<popped.length && popped[j]==st.peek()){
                st.pop();
                j++;
            }
        }
        
        if(st.size()==0) return true;
        return false;
    }
}