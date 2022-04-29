class MyCircularDeque {
    int []arr;
    int start,end,size;

    public MyCircularDeque(int k) {
        arr=new int[k];
        start=-1;
        end=-1;
        size=0;
        
    }
    
    public boolean insertFront(int value) {
        if(size==arr.length) return false;
        if(end==-1) end=0;
        if(start==-1){
            start=0;
            arr[start]=value;
            size++;
            return true;
        }
        start = start-1;
        if(start<0) start+=arr.length;
        arr[start] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(start==-1) start=0; 
        if(size==arr.length) return false;
        end = (end + 1)%arr.length;
        arr[end] = value;
        //System.out.println(end);
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0) return false;
        start = (start+1)%arr.length;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size==0) return false;
        end = end-1;
        if(end<0) end +=arr.length;
        size--;
        return true;
    }
    
    public int getFront() {
        if(size==0) return -1;
        return arr[start];
    }
    
    public int getRear() {
        if(size==0) return -1;
        return arr[end];
    }
    
    public boolean isEmpty() {
        if(size==0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(size==arr.length) return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */