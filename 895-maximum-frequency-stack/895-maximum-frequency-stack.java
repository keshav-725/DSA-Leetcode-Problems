class FreqStack {
    HashMap<Integer,Integer> map1;
    HashMap<Integer,Stack<Integer>> map2;
    int mfreq;
    public FreqStack() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        mfreq = 0;
    }
    
    public void push(int val) {
        map1.put(val,map1.getOrDefault(val,0)+1);
        int freq = map1.get(val);
        map2.putIfAbsent(freq,new Stack<Integer>());
        map2.get(freq).push(val);
        mfreq = Math.max(mfreq,freq);
        //System.out.println(mfreq);
    }
    
    public int pop() {
        int temp = map2.get(mfreq).pop();
        if(map2.get(mfreq).size()==0){
            map2.remove(mfreq);
            mfreq--;
        }
        map1.put(temp,map1.get(temp)-1);
        return temp; 
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */