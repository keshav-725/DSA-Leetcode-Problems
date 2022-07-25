class Solution {
    public int find(int []parent,int x){
        if(parent[x]==x) return x;
        
        int res = find(parent,parent[x]);
        parent[x] = res;
        return res;
    }
    public void union(int lx,int ly,int []parent,int []rank){
        if(rank[lx]<rank[ly]){
            parent[lx]=ly;
        }else if(rank[lx]>rank[ly]){
            parent[ly]=lx;
        }else{
            parent[lx]=ly;
            rank[ly]++;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int size = points.length * (points.length-1)/2;
        int [][]coord = new int[size][3];
        int idx=0;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                int []cord = {i,j,dist};
                coord[idx]=cord;
                idx++;
            }
        }
        Arrays.sort(coord,(val1,val2)->Integer.compare(val1[2],val2[2]));
        int cost=0;
        int []parent = new int[points.length];
        int []rank = new int[points.length];
        for(int i=0;i<points.length;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<size;i++){
            int u=coord[i][0];
            int v =coord[i][1];
            int w = coord[i][2];
            
            int lu = find(parent,u);
            int lv = find(parent,v);
            
            if(lu==lv) continue;
            union(lu,lv,parent,rank);
            cost+=w;
        }
        return cost;
    }
}