class Solution {
    public int regionsBySlashes(String[] grid) {
        int []parent = new int[4*grid.length*grid.length];
        int []rank = new int[4*grid.length*grid.length];
        
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length();j++){
                char ch = grid[i].charAt(j);
                
                int bno = i * grid.length + j;
                
                if(ch!='/'){
                    unionHelper(parent,rank,4*bno+0,4*bno+1);
                    unionHelper(parent,rank,4*bno+2,4*bno+3);
                }
                
                if(ch!='\\'){
                    unionHelper(parent,rank,4*bno+0,4*bno+3);
                    unionHelper(parent,rank,4*bno+1,4*bno+2);
                }
                
                if(i>0){
                    int obno = (i-1) * grid.length + j;
                    unionHelper(parent,rank,4*bno+0,4*obno+2);
                }
                if(j>0){
                    int obno = (i) * grid.length + (j-1);
                    unionHelper(parent,rank,4*bno+3,4*obno+1);
                }
                if(i<grid.length-1){
                    int obno = (i+1) * grid.length + (j);
                    unionHelper(parent,rank,4*bno+2,4*obno+0);
                }
                
                if(j<grid[i].length()-1){
                    int obno = (i) * grid.length + (j+1);
                    unionHelper(parent,rank,4*bno+1,4*obno+3);
                }
            }
        }
        int count = 0;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==i) count++;
        }
        return count;
    }
    public int find(int []parent,int x){
        if(parent[x]==x) return x;
        
        parent[x] = find(parent,parent[x]);
        return parent[x];
    }
    public void union(int []parent,int []rank,int lx,int ly){
        if(rank[lx]<rank[ly]){
            parent[lx] = ly;
        }else if(rank[lx]>rank[ly]){
            parent[ly] = lx;
        }else{
            parent[lx] = ly;
            rank[ly]++;
        }
    }
    public void unionHelper(int []parent,int []rank,int lx,int ly){
        int px = find(parent,lx);
        int py = find(parent,ly);
        
        if(px!=py){
            union(parent,rank,px,py);
        }
    }
}