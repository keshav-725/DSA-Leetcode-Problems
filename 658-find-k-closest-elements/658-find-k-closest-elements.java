class Solution {
    class Pair implements Comparable<Pair>{
        int ival;
        int diff;
        Pair(int ival,int diff){
            this.ival = ival;
            this.diff = diff;
        }
        public int compareTo(Pair o){
            if(this.diff==o.diff){
                return this.ival-o.ival;
            }
            return this.diff - o.diff;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(new Pair(arr[i],Math.abs(x-arr[i])));
        }
        List<Integer> list = new ArrayList<>();
        while(k-->0){
            Pair rem = pq.poll();
            list.add(rem.ival);
        }
        Collections.sort(list);
        return list;
    }
}