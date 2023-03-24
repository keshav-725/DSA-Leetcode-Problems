class Solution {
    
    private int count;

    public int minReorder(int n, int[][] connections) {
        var adj = new List[n];

        for (int i = 0; i < n; ++i) 
            adj[i] = new ArrayList<int[]>();

        for (int[] c : connections) {
            adj[c[0]].add(new int[]{c[1], 0});
            adj[c[1]].add(new int[]{c[0], 1});
        }

        var visited = new boolean[n];

        dfs(visited, adj, 0);

        return count;
    }

    private void dfs(boolean[] visited, List<int[]>[] adj, int v) {
        visited[v] = true;
        for (var w: adj[v]) {
            if (!visited[w[0]]) {
                if (w[1] == 0) count++;
                dfs(visited, adj, w[0]);
            }
        }
    }
}