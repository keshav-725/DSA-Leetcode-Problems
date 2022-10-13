class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int []dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        for(int i=1;i<=k+1;i++){
            int []dp1 = dist.clone();
            
            for(int []arr : flights){
                int u = arr[0];
                int v = arr[1];
                int uv = arr[2];
                
                if(dist[u]!=Integer.MAX_VALUE){
                    dp1[v] = Math.min(dp1[v],dist[u]+uv);
                }
            }
            dist = dp1;
        }
        if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}