class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }
        int []ans = new int[k];
        for(int i=0;i<k;i++){
            Pair rem = pq.poll();
            ans[i] = rem.num;
        }
        return ans;
    }
    public class Pair implements Comparable<Pair>{
        int num;
        int count;
        
        Pair(int num,int count){
            this.num = num;
            this.count = count;
        }
        
        public int compareTo(Pair other){
            return this.count-other.count;
        }
    }
}