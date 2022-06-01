class Solution {
    public int find(int []parent,int x){
        if(parent[x]==x) return x;
        int temp = find(parent,parent[x]);
        parent[x]=temp;
        return temp;
    }
    public void union(int []parent,int []rank,int x,int y){
        if(rank[x]<rank[y]){
            parent[x]=y;
        }else if(rank[x]>rank[y]){
            parent[y]=x;
        }else{
            parent[x]=y;
            rank[y]++;
        }
    }
    public boolean equationsPossible(String[] equations) {
        int []parent = new int[26];
        int []rank = new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1)=='='){
                int x = equations[i].charAt(0)-'a';
                int y = equations[i].charAt(3)-'a';
                
                int lx = find(parent,x);
                int ly = find(parent,y);
                
                if(lx==ly) continue;
                union(parent,rank,lx,ly);
            }
        }
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1)=='!'){
                int x = equations[i].charAt(0)-'a';
                int y = equations[i].charAt(3)-'a';
                
                int lx = find(parent,x);
                int ly = find(parent,y);
                
                if(lx==ly) return false;
            }
        }
        return true;
    }
}