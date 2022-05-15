class Pair{
    int v;
    int w;
    public Pair(int v,int w){
        this.v=v;
        this.w=w;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        LinkedList<Pair> []graph=new LinkedList[n+1];
        for(int i=0;i<=n;i++)
            graph[i]=new LinkedList<Pair>();
        for(int i=0;i<times.length;i++){
            graph[times[i][0]].add(new Pair(times[i][1],times[i][2]));
        }
        int ans=0;
        //boolean visited[]=new boolean[n+1];
        int value[] = new int[n+1];
        Arrays.fill(value,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.w-b.w;
        });
        pq.add(new Pair(k,0));
        value[k]=0;
        while(pq.isEmpty()==false){
            int u=pq.remove().v;
            for(Pair p:graph[u]){
                int v=p.v;
                int w=p.w;
                if(value[u]!=Integer.MAX_VALUE && value[v] > (value[u]+w)){
                    pq.add(new Pair(v,w));
                    value[v]=value[u]+w;
                }
            }
        }
        for(int i=1;i<=n;i++){
            ans=Math.max(ans,value[i]);
        }
        if(ans==Integer.MAX_VALUE)   return -1;
        return ans;
    }
}