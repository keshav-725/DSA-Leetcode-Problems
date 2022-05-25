class Solution {
    public int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0;i<connections.size();i++){
            int start = connections.get(i).get(0);
            int end = connections.get(i).get(1);
            
            graph.putIfAbsent(start,new ArrayList<>());
            graph.putIfAbsent(end,new ArrayList<>());
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        // int n=graph.size();
        int []parent = new int[n];
        int []disc = new int[n];
        int []low = new int[n];
        boolean []vis = new boolean[n];
        boolean []art = new boolean[n];
        parent[0]=-1;
        time=0;
        articulationGraph(ans,graph,0,parent,disc,low,vis,art);
        return ans;
    }
    public void articulationGraph(List<List<Integer>> ans,HashMap<Integer,ArrayList<Integer>> graph,int src,int []parent,int []disc,int []low,boolean []vis,boolean []art){
        disc[src]=low[src]=time;
        time++;
        vis[src]=true;
        int count=0;
        for(int nbr:graph.get(src)){
            if(vis[nbr]==true && parent[src]!=nbr){
                low[src] = Math.min(low[src],disc[nbr]);
            }else if(vis[nbr]==false){
                parent[nbr]=src;
                articulationGraph(ans,graph,nbr,parent,disc,low,vis,art);
                low[src]= Math.min(low[src],low[nbr]);
                count++;
                if(disc[src]<low[nbr]){
                    art[src]=true;
                    List<Integer> tans = new ArrayList<>();
                    tans.add(src);
                    tans.add(nbr);
                    ans.add(tans);
                }
            }
        }
                      
    }
}