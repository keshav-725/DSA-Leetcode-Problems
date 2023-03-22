class Solution {
    int ans;
    class Pair{
        int dest,value;
        Pair(int dest,int value){
            this.dest = dest;
            this.value = value;
        }
    }
    public int minScore(int n, int[][] roads) {
        
        ans = Integer.MAX_VALUE;
        ArrayList<Pair>[] list = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        for(int []road : roads){
            int u = road[0];
            int v = road[1];
            int val = road[2];
            
            list[u].add(new Pair(v,val));
            list[v].add(new Pair(u,val));
        }
        boolean []visited = new boolean[n+1];
        helper(1,visited,list);
        return ans;
    }
    public void helper(int idx,boolean []visited,ArrayList<Pair>[] list){
        
        visited[idx] = true;
        
        for(Pair p : list[idx]){
            int dest = p.dest;
            int val = p.value;
            ans = Math.min(ans,val);
            if(!visited[dest]){
                helper(dest,visited,list);
            }
        }
    }
}