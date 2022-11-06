class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(char ch : tasks){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch : map1.keySet()){
            pq.add(map1.get(ch));
        }
        int ans = 0;
        while(pq.size()>0){
            int time = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<n+1;i++){
                if(pq.size()>0){
                    list.add(pq.poll()-1);
                    time++;
                }
            }
            for(int it : list){
                if(it>0) pq.add(it);
            }
            if(pq.size()==0){
                ans += time;
            }else{
                ans += n+1;
            }
        }
        return ans;
    }
}