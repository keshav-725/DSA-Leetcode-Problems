class Solution {
    public class Pair implements Comparable<Pair>{
        int val;
        int f;
        Pair(int val,int f){
            this.val = val;
            this.f = f;
        }
        public int compareTo(Pair o){
            return o.f - this.f;
        }
    }
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
            
        }
        int count = 0,ans=0;
        while(count<(arr.length/2)){
            Pair rem = pq.poll();
            count += rem.f;
            ans++;
        }
        return ans;
    }
}