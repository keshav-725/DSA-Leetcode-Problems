class Solution {
    public int find(int []parent,int x){
        if(parent[x]==x) return x;
        
        int pox = find(parent,parent[x]);
        parent[x] = pox;
        return pox;
    }
    public void union(int []parent,int []rank,int lx,int ly){
        if(rank[lx]<rank[ly]){
            parent[lx]=ly;
        }else if(rank[lx]>rank[ly]){
            parent[ly]=lx;
        }else{
            parent[lx]=ly;
            rank[ly]++;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int []parent = new int[n];
        int []rank = new int[n];
        
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            rank[i]=0;
        }
        
        for(int i=0;i<isConnected.length;i++){
            int []arr = isConnected[i];
            for(int j=0;j<arr.length;j++){
                if(isConnected[i][j]==1){
                    int lx = find(parent,i);
                    int ly = find(parent,j);
                    
                    if(lx!=ly){
                        union(parent,rank,lx,ly);
                    }
                }
            }
        }
        int count = 0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==i) count++;
        }
        return count;
    }
}