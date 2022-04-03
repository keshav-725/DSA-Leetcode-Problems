class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val,list.size());
            list.add(val);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean remove(int val) {
        //System.out.println(list);
        if(map.containsKey(val)){
            int idx = map.get(val);
            int lindex = list.size()-1;
            int lvalue = list.get(lindex);
            list.set(idx,list.get(lindex));
            list.set(lindex,val);
            list.remove(lindex);
            map.replace(val,lindex);
            map.replace(lvalue,idx);
            map.remove(val);
            //System.out.println(list);
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        //System.out.println(list);
        Random r = new Random();
        int idx = r.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */