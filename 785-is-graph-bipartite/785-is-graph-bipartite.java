class Solution {
    public class Pair{
        int idx;
        char color;
        Pair(int idx,char color){
            this.idx = idx;
            this.color = color;
        }
    }
    public boolean isBipartite(int[][] graph) {
        LinkedList<Pair> queue = new LinkedList<>();
        HashMap<Integer,Character> map = new HashMap<>();
        for(int i=0;i<graph.length;i++){
            if(!map.containsKey(i)){
                queue = new LinkedList<>();
                queue.add(new Pair(i,'R'));
                boolean check = addToGraph(graph,map,queue);
                if(check==false) return false;
            }
        }
        return true;
    }
    public boolean addToGraph(int [][]graph,HashMap<Integer,Character> map,LinkedList<Pair> queue){
        while(queue.size()>0){
            Pair rem = queue.removeFirst();
            if(map.containsKey(rem.idx)){
                if(map.get(rem.idx)!=rem.color) return false;
                continue;
            }
            map.put(rem.idx,rem.color);
            // System.out.println(rem.idx);
            for(int j=0;j<graph[rem.idx].length;j++){
                char c;
                if(rem.color=='R') c='G';
                else c='R';
                
                queue.addLast(new Pair(graph[rem.idx][j],c));
            }
        }
        return true;
    }
}