class MinStack {

    Stack<Long> st;
    Long min;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int num) {
        long val = num;
        if(st.size()==0){
            st.push(val);
            min = val;
        }else if(val>=min){
            st.push(val);
        }else if(val<min){
            st.push(val+val-min);
            min = val;
        }
    }
    
    public void pop() {
        if(st.peek()<min){
            long val = st.pop();
            min = 2*min-val;
        }else{
            st.pop();
        }
    }
    
    public int top() {
        if(st.peek()<min){
            return min.intValue();
        }else{
            return st.peek().intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */