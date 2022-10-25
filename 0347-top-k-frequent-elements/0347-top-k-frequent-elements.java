class Solution {
    public class Pair implements Comparable<Pair>{
        int num;
        int freq;
        Pair(int num,int freq){
            this.num = num;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            return o.freq-this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }
        int []ans = new int[k];
        int i =0;
        while(k-->0){
            ans[i] = pq.poll().num;
            i++;
        }
        return ans;
    }
}