class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long []dp = new long[n+1];
        dp[1]=1;
        
        int []idx = new int[primes.length];
        Arrays.fill(idx,1);
        
        for(int i=2;i<=n;i++){
            long ans = Long.MAX_VALUE;
            
            for(int j=0;j<primes.length;j++){
                int prime = primes[j];
                int ind = idx[j];
                ans = Math.min(ans,prime * dp[ind]);
            }
            for(int j=0;j<primes.length;j++){
                int prime = primes[j];
                int ind = idx[j];
                if(ans==prime*dp[ind]) idx[j]++;
            }
            dp[i] = ans;
        }
        return (int)dp[n];
    }
}