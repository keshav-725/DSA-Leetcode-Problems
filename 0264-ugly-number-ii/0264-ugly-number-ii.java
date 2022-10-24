class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int []dp = new int[n+1];
        dp[1]=1;
        
        int tidx=1,thidx=1,fidx=1;
        
        for(int i=2;i<=n;i++){
            pq=new PriorityQueue<>();
            pq.add(2*dp[tidx]);
            pq.add(3*dp[thidx]);
            pq.add(5*dp[fidx]);
            
            int rem = pq.remove();
            dp[i] = rem;
            
            if(rem==2*dp[tidx]){
                tidx++;
            }
            if(rem==3*dp[thidx]){
                thidx++;
            }
            if(rem==5*dp[fidx]){
                fidx++;
            }
        }
        
        return dp[n];
    }
}