class Solution {
    public long countPairs(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        boolean []visited = new boolean[n];
        long ans=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            if(visited[i]==false){
                dfs(map,visited,set,i);
            }
            long rem = n-set.size();
            ans += rem * set.size();
        }
        ans = ans/2;
        return ans;
    }
    public void dfs(HashMap<Integer,ArrayList<Integer>> map,boolean []visited,HashSet<Integer> set,int i){
        visited[i]=true;
        set.add(i);
        if(map.containsKey(i)){
            for(int val : map.get(i)){
                if(visited[val]==false){
                    dfs(map,visited,set,val);
                }
            }
        }
    }
}