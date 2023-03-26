class Solution {
    int min;
    public int longestCycle(int[] edges) {
        boolean []visited = new boolean[edges.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        min = Integer.MIN_VALUE;
        for(int i=0;i<edges.length;i++){
            if(visited[i]==false){
                map = new HashMap<>();
                dfs(i,i,edges,visited,1,map);   
            }
        }
        return min==Integer.MIN_VALUE?-1:min;
    }
    public void dfs(int i,int start,int[] edges,boolean []visited,int val,HashMap<Integer,Integer> map){
        if(map.containsKey(edges[i])){
            System.out.println("edge->"+i+"+nbr->"+edges[i]);
            min = Math.max(min,val-map.get(edges[i])+1);
            return;
        }
        visited[i] = true;
        map.put(i,val);
        if(edges[i]!=-1 && visited[edges[i]]==false){
            dfs(edges[i],start,edges,visited,val+1,map);
        }
    }
}