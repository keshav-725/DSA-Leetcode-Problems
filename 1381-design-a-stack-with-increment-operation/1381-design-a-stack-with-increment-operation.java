class CustomStack {
    int []arr;
    int []temparr;
    int pointer = -1;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        temparr = new int[maxSize];
    }
    
    public void push(int x) {
        if(pointer==arr.length-1){
            return;
        }
        pointer++;
        arr[pointer] = x;
    }
    
    public int pop() {
        if(pointer==-1){
            return -1;
        }
        int val = arr[pointer]+temparr[pointer];
        if(pointer-1>=0){
            temparr[pointer-1] += temparr[pointer];
        }
        temparr[pointer]=0;
        pointer--;
        return val;
    }
    
    public void increment(int k, int val) {
        if(pointer==-1) return;
        k = Math.min(k,pointer+1);
        temparr[k-1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */