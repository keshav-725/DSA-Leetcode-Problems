class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list = new ArrayList<>();
        
        for(int i=0;i<buildings.length;i++){
            int start = buildings[i][0];
            int end = buildings[i][1];
            int ht = buildings[i][2];
            
            list.add(new Pair(start,-ht));
            list.add(new Pair(end,ht));
        }
        Collections.sort(list);

        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int cht = 0;
        pq.add(0);
        for(int i=0;i<list.size();i++){
            int x = list.get(i).x;
            int ht = list.get(i).height;

            if(ht<0){
                pq.add(-ht);
            }else if(ht>0){
                pq.remove(ht);
            }

            if(cht != pq.peek()){
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(pq.peek());

                ans.add(temp);

                cht = pq.peek();
            }
        }
        return ans;
    }
    public class Pair implements Comparable<Pair>{
        int x;
        int height;
        
        Pair(int x,int height){
            this.x = x;
            this.height = height;
        }
        
        public int compareTo(Pair o){
            if(this.x != o.x){
                return this.x-o.x;
            }else{
                return this.height - o.height;
            }
        }
    }
}