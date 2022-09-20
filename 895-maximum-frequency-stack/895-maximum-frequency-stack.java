class FreqStack {

    HashMap<Integer,Integer> map1;
    HashMap<Integer,ArrayList<Integer>> map2;
    int max = Integer.MIN_VALUE;
    public FreqStack() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void push(int val) {
        map1.put(val,map1.getOrDefault(val,0)+1);
        int num = map1.get(val);
        map2.putIfAbsent(num,new ArrayList<>());
        map2.get(num).add(val);
        max = Math.max(max,num);
    }
    
    public int pop() {
        ArrayList<Integer> temp = map2.get(max);
        int ans = temp.get(temp.size()-1);
        temp.remove(temp.size()-1);
        if(temp.size()==0) max--;
        map1.put(ans,map1.getOrDefault(ans,0)-1);
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */