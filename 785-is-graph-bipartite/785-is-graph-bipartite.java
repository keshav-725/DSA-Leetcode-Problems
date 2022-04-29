class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        
        for(int i=0;i<graph.length;i++) {
            if(color[i] == -1) {
                if(!BFS(i,color,graph)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean BFS(int curNode, int color[],int[][] graph) {
        Queue<Integer> que = new LinkedList<>();
        que.add(curNode);
        color[curNode] = 0;
        int curColor = 0;
        
        while(!que.isEmpty()) {
            int node = que.remove();
            curColor = color[node] == 0 ? 1 : 0;
            int adjNodes[] = graph[node];
            for(int adjNode : adjNodes) {
                if(color[adjNode] == -1) {
                    color[adjNode] = curColor;
                    que.add(adjNode);
                } else {
                    if(color[adjNode] != curColor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}