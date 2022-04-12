class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int pumps=0,i=0;
        while(startFuel<target){
            while(i<stations.length && stations[i][0]<=startFuel){
                pq.add(stations[i][1]);
                i++;
            }
            if(pq.size()==0) return -1;
            startFuel += pq.remove();
            pumps++;
        }

        return pumps;
    }
}