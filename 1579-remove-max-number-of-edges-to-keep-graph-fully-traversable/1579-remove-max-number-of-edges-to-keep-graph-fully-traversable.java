class Solution {
    public int find(int []parent,int x){
        if(parent[x]==x) return x;
        parent[x] = find(parent,parent[x]);
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
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int []aparent = new int[n+1];
        int []bparent = new int[n+1];
        
        int []arank = new int[n+1];
        int []brank = new int[n+1];
        
        for(int i=0;i<aparent.length;i++){
            aparent[i]=i;
            bparent[i]=i;
            arank[i]=0;
            brank[i]=0;
        }
        
        int count =0;
        
        for(int []arr : edges){
            int type = arr[0];
            int st = arr[1];
            int en = arr[2];
            
            if(type==3){
                
                int apx = find(aparent,st);
                int apy = find(aparent,en);
                
                int bpx = find(bparent,st);
                int bpy = find(bparent,en);
                
                if((apx==apy) && (bpx==bpy)){
                    count++;
                }else{
                    union(aparent,arank,apx,apy);
                    union(bparent,brank,bpx,bpy);
                }
            }
        }
        for(int []arr : edges){
            int type = arr[0];
            int st = arr[1];
            int en = arr[2];
            
            
            if(type==1){
                int apx = find(aparent,st);
                int apy = find(aparent,en);
                
                if(apx==apy){
                    count++;
                }else{
                    union(aparent,arank,apx,apy);
                }
            }else if(type==2){
                int bpx = find(bparent,st);
                int bpy = find(bparent,en);
                
                if(bpx==bpy){
                    count++;
                }else{
                    union(bparent,brank,bpx,bpy);
                }
            }
        }
        int naparent=0,nbparent=0;
        for(int i=1;i<aparent.length;i++){
            if(aparent[i]==i) naparent++;
            if(bparent[i]==i) nbparent++;
        }
        if(naparent>1 || nbparent>1) return -1;
        return count;
        
    }
}