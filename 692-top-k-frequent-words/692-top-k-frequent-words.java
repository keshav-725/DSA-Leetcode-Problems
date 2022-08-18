class Solution {
    class Pair implements Comparable<Pair>{
        String str;
        int freq;
        Pair(String str,int freq){
            this.str = str;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            if(o.freq == this.freq) return this.str.compareTo(o.str);
            return Integer.compare(o.freq,this.freq);
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(String s: map.keySet()){
            pq.add(new Pair(s,map.get(s)));
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            Pair rem = pq.poll();
            list.add(rem.str);
        }
        return list;
    }
}