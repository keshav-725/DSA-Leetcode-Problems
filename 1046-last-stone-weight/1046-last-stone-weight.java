class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int fno = pq.poll();
            int sno = pq.poll();
            if(fno==sno){
                continue;
            }else{
                pq.add(fno-sno);
            }
        }
        return pq.size()>0?pq.peek():0;
    }
}