class Solution {
    public int fillCups(int[] amount) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(amount[0]);
        pq.add(amount[1]);
        pq.add(amount[2]);
        while(pq.peek()!=0){
            int fnum = pq.poll();
            int snum = pq.poll();
            fnum--;
            snum--;
            pq.add(fnum);
            pq.add(snum);
            count++;
        }
        return count;
    }
}