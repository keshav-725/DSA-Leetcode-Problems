class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<trips.length;i++){
            int stime = trips[i][1];
            int etime = trips[i][2];
            int passenger = trips[i][0];
            if(map.containsKey(stime)){
                map.put(stime,map.get(stime)+passenger);
            }else{
                map.put(stime,passenger);
            }
            if(map.containsKey(etime)){
                map.put(etime,map.get(etime)-passenger);
            }else{
                map.put(etime,-passenger);
            }
        }
        int count = 0,max = 0;
        for(int key : map.keySet()){
            count += map.get(key);
            max = Math.max(count,max);
        }
        return max<=capacity;
    }
}