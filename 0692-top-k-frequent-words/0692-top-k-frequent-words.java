class Solution {
    class Pair implements Comparable<Pair>{
        String s;
        int freq;
        Pair(String s,int freq){
            this.s = s;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            if(this.freq == o.freq) return this.s.compareTo(o.s);
            return o.freq-this.freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(String s : map.keySet()){
            pq.add(new Pair(s,map.get(s)));
        }
        List<String> ans = new ArrayList<>();
        while(k-->0){
            Pair rem = pq.poll();
            ans.add(rem.s);
            
        }
        return ans;
    }
}