class StockSpanner {
    
    HashMap<Integer,ArrayList<Integer>> map;
    Stack<Integer> st;
    int count;

    public StockSpanner() {
        map = new HashMap<>();
        st = new Stack<>();
        count=0;
    }
    
    public int next(int price) {
        while(st.size()>0 && st.peek()<=price){
            ArrayList<Integer> temp = map.get(st.peek());
            temp.remove(temp.size()-1);
            st.pop();
        }
        int ans;
        if(st.size()==0){
            ans = count+1;
        }else{
            ArrayList<Integer> temp = map.get(st.peek());
            int idx = temp.get(temp.size()-1);
            ans = count-idx;
        }
        st.push(price);
        map.putIfAbsent(price,new ArrayList<>());
        map.get(price).add(count);
        count++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */