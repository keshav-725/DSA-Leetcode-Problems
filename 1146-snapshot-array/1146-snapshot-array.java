class SnapshotArray {
    
    HashMap<Integer,Integer>[] map;
    int snapcount;
    
    public SnapshotArray(int length) {
        map = new HashMap[length];
        for(int i=0;i<length;i++){
            map[i] = new HashMap<>();
        }
        snapcount =0;
    }
    
    public void set(int index, int val) {
        HashMap<Integer,Integer> tempmap = map[index];
        tempmap.put(snapcount,val);
    }
    
    public int snap() {
        return snapcount++;
    }
    
    public int get(int index, int snap_id) {
        while(snap_id >=0 && !map[index].containsKey(snap_id)){
            snap_id--;
        }
        return snap_id<0?0:map[index].get(snap_id);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */