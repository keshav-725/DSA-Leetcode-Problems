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
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        PriorityQueue<Character>[] pq = new PriorityQueue[s.length()];
        for(int i=0;i<s.length();i++){
            pq[i] = new PriorityQueue<>();
        }
        int []parent = new int[s.length()];
        int []rank = new int[s.length()];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(List<Integer> list : pairs){
            int fi = list.get(0);
            int si = list.get(1);
            
            int px = find(parent,fi);
            int py = find(parent,si);
            
            if(px!=py){
                union(parent,rank,px,py);
            }
        }
        for(int i=0;i<parent.length;i++){
            char ch = s.charAt(i);
            int pi = find(parent,i);
            
            pq[pi].add(ch);
        }
        
        Character []chararr = new Character[s.length()];
        for(int i=0;i<parent.length;i++){
            int pi = find(parent,i);
            chararr[i] = pq[pi].poll();
            
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<chararr.length;i++){
            sb.append(chararr[i]);
        }
        return sb.toString();
    }
}