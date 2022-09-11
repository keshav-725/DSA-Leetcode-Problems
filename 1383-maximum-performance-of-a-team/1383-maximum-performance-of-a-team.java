class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long sum = 0;
        long res = 0;
        long mod = 1000000007;
        int[][] engs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            engs[i][0] = efficiency[i];
            engs[i][1] = speed[i];
        }
        
        Arrays.sort(engs, (a, b) -> (b[0] - a[0]));
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        for (int i = 0; i < n; i++) {
            int[] tmp = engs[i];
            
            if (heap.size() == k) {
                int[] tt = heap.poll();
                sum -= tt[1];
            }
            heap.offer(tmp);
            sum = sum + tmp[1];
            
            res = Math.max(res, sum * tmp[0]);
            
        }
        return (int) (res % mod);
    }
}