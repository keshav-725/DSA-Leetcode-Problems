class Solution {
    public int find(int []parent,int x){
        if(parent[x]==x) return x;
        
        parent[x]=find(parent,parent[x]);
        return parent[x];
    }
    public void union(int []parent,int []rank,int lx,int ly){
        if(rank[lx]<rank[ly]){
            parent[lx] = ly;
        }else if(rank[ly]<rank[lx]){
            parent[ly] = lx;
        }else{
            parent[lx] = ly;
            rank[ly]++;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int []parent = new int[edges.length+1];
        int []rank = new int[edges.length+1];
        
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(int []arr : edges){
            int left = arr[0];
            int right = arr[1];
            
            int pleft = find(parent,left);
            int pright = find(parent,right);
            
            if(pleft==pright) return arr;
            else{
                union(parent,rank,pleft,pright);
            }
        }
        return null;
    }
}