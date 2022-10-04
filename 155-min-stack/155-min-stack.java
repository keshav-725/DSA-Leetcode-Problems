class MinStack {
    TreeMap<Integer,Integer> map;
    Stack<Integer> st;
    public MinStack() {
        st=new Stack<>();
        map = new TreeMap<>();
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        st.push(val);
    }
    
    public void pop() {
        int val = st.pop();
        map.put(val,map.get(val)-1);
        if(map.get(val)==0) map.remove(val);
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return map.firstKey();
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