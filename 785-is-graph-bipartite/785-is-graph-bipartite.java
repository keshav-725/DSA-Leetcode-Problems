class Solution {
    public class Pair{
        int val;
        char color;
        Pair(int val,char color){
            this.val = val;
            this.color = color;
        }
    }
    public boolean isBipartite(int[][] graph) {
        LinkedList<Pair> queue = new LinkedList<>();
        HashMap<Integer,Character> map = new HashMap<>();
        for(int i=0;i<graph.length-1;i++){
            if(!map.containsKey(i)){
                queue.add(new Pair(i,'r'));
                map.put(i,'r');
                boolean check = addToQueue(i,graph,queue,map);
                if(check==false) return false;
            }
        }
        return true;
    }
    public boolean addToQueue(int j,int [][]graph,LinkedList<Pair> queue,HashMap<Integer,Character> map ){
        while(queue.size()>0){
            Pair rem = queue.removeFirst();
            for(int i=0;i<graph[rem.val].length;i++){
                char ncolor = rem.color=='r'?'g':'r';
                int num = graph[rem.val][i];
                if(map.containsKey(num)){
                    if(map.get(num)!=ncolor) return false;
                    else continue;
                }
                map.put(num,ncolor);
                queue.addLast(new Pair(num,ncolor));
            }
        }
        return true;
    }
}