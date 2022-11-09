class StockSpanner {

    class Pair{
        int idx;
        int price;
        Pair(int idx,int val){
            this.idx = idx;
            this.price = val;
        }
    }
    private Stack<Pair> st;
    private int count;
    
    public StockSpanner() {
        st = new Stack<>();
        count = 0;
    }
    
    public int next(int price) {
        while(st.size()>0 && st.peek().price<=price){
            st.pop();
        }
        int ans;
        ans = (st.size()==0) ? (count+1) : (count-st.peek().idx);
        st.push(new Pair(count++,price));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */