class FreqStack {
    
    HashMap<Integer,Integer> fmap;
    HashMap<Integer,Stack<Integer>> smap;
    int mfrq=0;
    
    public FreqStack() {
        fmap = new HashMap<>();
        smap = new HashMap<>();
    }
    
    public void push(int val) {
        fmap.put(val,fmap.getOrDefault(val,0)+1);
        int count = fmap.get(val);
        if(smap.containsKey(count)){
            smap.get(count).push(val);
        }else{
            Stack<Integer> temp = new Stack<>();
            temp.push(val);
            smap.put(count,temp);
        }
        if(count>mfrq) mfrq=count;
    }
    
    public int pop() {
        int rem = smap.get(mfrq).pop();
        if(smap.get(mfrq).size()==0){
            mfrq--;
        }
        fmap.put(rem,fmap.get(rem)-1);
        return rem;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */