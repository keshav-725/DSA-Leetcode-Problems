class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashSet<Integer>[] graph = new HashSet[n];
        for(int i=0;i<n;i++){
            graph[i] = new HashSet<>();
        }
        for(int []arr : edges){
            int u = arr[0];
            int v = arr[1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        int []nodes = new int[n];
        int []res = new int[n];
        helper1(graph,nodes,res,0,-1);
        helper2(graph,nodes,res,0,-1);
        return res;
    }
    public void helper2(HashSet<Integer>[] graph,int []nodes,int []res,int src,int par){
        for(int nbr : graph[src]){
            if(nbr!=par){
                res[nbr] = res[src] + (nodes.length-nodes[nbr]) - nodes[nbr];
                helper2(graph,nodes,res,nbr,src);
            }
        }
    }
    public void helper1(HashSet<Integer>[] graph,int []nodes,int []res,int src,int par){
        
        for(int nbr : graph[src]){
            if(nbr!=par){
                helper1(graph,nodes,res,nbr,src);
                nodes[src] += nodes[nbr];
                res[src] += nodes[nbr]+res[nbr];
            }
        }
        nodes[src]++;
    }
}