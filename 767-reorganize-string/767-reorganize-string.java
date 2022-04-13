class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char key:map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }
        StringBuilder sb = new StringBuilder("");
        Pair block = pq.poll();
        sb.append(block.ch);
        block.freq--;
        while(pq.size()>0){
            Pair temp = pq.poll();
            sb.append(temp.ch);
            temp.freq--;
            if(block.freq>0){
                pq.add(block);
            }
            block= temp;
        }
        if(block.freq>0) return "";
        return sb.toString();
    }
    public class Pair implements Comparable<Pair>{
        char ch;
        int freq;
        
        Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            return this.freq-o.freq;
        }
    }
}