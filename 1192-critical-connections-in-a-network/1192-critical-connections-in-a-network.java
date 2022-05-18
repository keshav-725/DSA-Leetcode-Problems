class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Set<Integer>> adj = new ArrayList<>();
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new HashSet<>()); // We use hashset so that removal of edge is quick
            parent[i] = -1;
        }
        for(List<Integer> edge: connections) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++) {
            if(!visited[i]){
                getOrder(adj, stack, parent, visited, i); // Fill stack for ordering
            }
        }
        
        for(int i=0;i<n;i++){
            if(parent[i]!=-1){
                adj.get(parent[i]).remove(i); // This is similar to the case where we have to build the transpose graph as per Kosaraju's Algo
            }
        }
        Arrays.fill(visited, false);
        
        List<List<Integer>> criticals = new ArrayList<>();
        while(!stack.isEmpty()) {
            int v = stack.pop();
            if(!visited[v]){
                if(parent[v]!=-1){
                    criticals.add(Arrays.asList(parent[v], v)); // Whenever we pop from stack and the component is unvisited it means a new SCC 
                }
                dfs(adj, visited, v);
            }
        }
        
        return criticals;
    }
    
    private void getOrder(List<Set<Integer>> adj, Stack<Integer> stack, int[] parent, boolean[] visited, int s) {
        visited[s] = true;
        
        for(int n: adj.get(s)) {
            if(!visited[n]){
                parent[n] = s;
                getOrder(adj, stack, parent, visited, n);
            }
        }
        
        stack.push(s);
    }
    
    private void dfs(List<Set<Integer>> adj, boolean[] visited, int s) {
        visited[s] = true;
        
        for(int n: adj.get(s)) {
            if(!visited[n]){
                dfs(adj, visited, n);
            }
        }
        
    }
}