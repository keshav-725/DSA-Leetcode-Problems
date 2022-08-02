class Solution {
    public class Pair implements Comparable<Pair>{
        int pos;
        int speed;
        
        Pair(int pos,int speed){
            this.pos = pos;
            this.speed = speed;
        }
        public int compareTo(Pair o){
            return o.pos - this.pos;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<position.length;i++){
            pq.add(new Pair(position[i],speed[i]));
        }
        ArrayList<Float> time = new ArrayList<>();
        while(pq.size()>0){
            Pair rem = pq.poll();
            float remtime = (float)((target-rem.pos)*1.0/rem.speed);
            if(time.size()>0){
                if(time.get(time.size()-1)>=remtime){
                    time.set(time.size()-1,Math.max(remtime,time.get(time.size()-1)));
                }else{
                    time.add(remtime);
                }
            }else{
                time.add(remtime);
            }
        }
        return time.size();
    }
}