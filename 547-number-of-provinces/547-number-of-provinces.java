class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0;i<isConnected.length;i++){
            int []arr = isConnected[i];
            for(int j=0;j<arr.length;j++){
                graph.putIfAbsent(i+1,new ArrayList<>());
                graph.putIfAbsent(j+1,new ArrayList<>());
                if(isConnected[i][j]==1 && i!=j){
                    graph.get(i+1).add(j+1);
                }
            }
        }
        // System.out.println(graph);
        boolean []visited = new boolean[isConnected.length+1];
        int count=0;
        for(int i=1;i<isConnected.length+1;i++){
            if(visited[i]==false){
                count++;
                dfs(graph,visited,i);
            }
        }
        return count;
    }
    public void dfs(HashMap<Integer,ArrayList<Integer>> graph,boolean []visited,int idx){
        visited[idx]=true;
        
        if(graph.containsKey(idx)){
            for(int val : graph.get(idx)){
                if(visited[val]==false){
                    dfs(graph,visited,val);
                }
            }
        }
    }
}