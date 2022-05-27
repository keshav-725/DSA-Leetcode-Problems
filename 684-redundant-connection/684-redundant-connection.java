class Solution {
    public int find(int []parent,int x){
        if(parent[x]==x) return x;
        
        int temp = find(parent,parent[x]);
        parent[x]=temp;
        return temp;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans= new int[2];
        int n = edges.length;
        int []parent = new int[n+1];
        int []rank = new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<n;i++){
            int left = edges[i][0];
            int right = edges[i][1];
            
            int lx = find(parent,left);
            int ly = find(parent,right);
            
            if(lx!=ly){
                if(rank[lx]<rank[ly]){
                    parent[lx]=ly;
                }else if(rank[lx]>rank[ly]){
                    parent[ly]=lx;
                }else{
                    parent[lx]=ly;
                    rank[ly]++;
                }
            }else{
                ans[0]=left;
                ans[1]=right;
                
                return ans;
            }
        }
        return ans;
    }
}