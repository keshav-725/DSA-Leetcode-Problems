class RandomizedCollection {
    
    HashMap<Integer,Set<Integer>> map;
    ArrayList<Integer> list;
    Random r;
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            map.get(val).add(list.size());
            list.add(val);
            return false;
        }else{
            Set<Integer> set = new HashSet<>();
            set.add(list.size());
            map.put(val,set);
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            Set<Integer> tempset = map.get(val);
            int idx = tempset.iterator().next();
            int lindex = list.size()-1;
            
            if(tempset.size()==1){
                map.remove(val);
            }else{
                tempset.remove(idx);
            }
            
            if(idx != lindex){
                int lvalue = list.get(lindex);
                Set<Integer> lastidxset = map.get(lvalue);
                lastidxset.add(idx);
                lastidxset.remove(lindex);
                list.set(idx,lvalue);
            }
            list.remove(lindex);
            
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */