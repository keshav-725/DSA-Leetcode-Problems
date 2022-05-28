class Solution {
    private int[] parent;
    private int[]rank;
    public int find(int x){
        if(parent[x]==x) return x;
        
        int res = find(parent[x]);
        parent[x]=res;
        return res;
    }
    public boolean union(int x,int y){
        int lx = find(x);
        int ly = find(y);
        if(lx==ly) return true;
        else{
            if(rank[lx]<rank[ly]){
                parent[lx]=ly;
            }else if(rank[ly]<rank[lx]){
                parent[ly]=lx;
            }else{
                parent[lx]=ly;
                rank[ly]++;
            }
        }
        return false;
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int blacklist1=-1;
        int blacklist2=-1;
        int []indegree = new int[n+1];
        Arrays.fill(indegree,-1);
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(indegree[v]!=-1){
                blacklist1=i;
                blacklist2=indegree[v];
                break;
            }
            indegree[v]=i;
        }
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<n;i++){
            if(i==blacklist1){
                continue;
            }
            int u=edges[i][0];
            int v = edges[i][1];
            
            boolean isCyclic = union(u,v);
            if(isCyclic==true){
                if(blacklist1==-1){
                    return edges[i];
                }else{
                    return edges[blacklist2];
                }
            }
        }
        return edges[blacklist1];
    }
}