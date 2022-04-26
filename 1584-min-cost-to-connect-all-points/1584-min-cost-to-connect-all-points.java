class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, curr = 0, count = 0, ans = 0;
        int[] minDist = new int[n];
        Arrays.fill(minDist, 2_000_000_000);
        
        while(++count<n){
            minDist[curr] = Integer.MAX_VALUE;
            int next = 0;
            for(int i=0;i<n;i++){
                if(minDist[i] != Integer.MAX_VALUE){
                    minDist[i] = Math.min(minDist[i], Math.abs(points[curr][0] - points[i][0])+Math.abs(points[curr][1] - points[i][1]));
                    if(minDist[i] < minDist[next]) next = i;
                }
            }
            ans += minDist[(curr = next)];
        }
        return ans;
    }
}