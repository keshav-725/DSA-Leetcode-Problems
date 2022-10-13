class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int []visited = new int[graph.length];
        
        for(int i=0;i<graph.length;i++){
            
            boolean check = dfs(i,visited,graph);
            if(check) ans.add(i);
        }
        return ans;
    }
    public boolean dfs(int i,int []visited,int [][]graph){
        if(visited[i]==2){
            return true;
        }else if(visited[i]==1){
            return false; 
        }else{
            visited[i] = 1;
            for(int n : graph[i]){
                boolean check = dfs(n,visited,graph);
                if(check==false) return false;
            }
            visited[i] = 2;
            return true;
        }
    }
}