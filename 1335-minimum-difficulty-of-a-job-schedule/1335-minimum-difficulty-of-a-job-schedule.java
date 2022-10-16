class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d) {
            return -1;
        }

        int[][] dp = new int[n][d + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int dd = 1; dd < d + 1; dd++) {
            for (int i = n - dd; i >= 0; i--) {
                if (dd == 1) {
                    if (i == n - 1) dp[i][dd] = jobDifficulty[n - 1];
                    else dp[i][dd] = Math.max(jobDifficulty[i], dp[i + 1][dd]);
                }
                else {
                    int maxJobDiff = 0;
                    for (int j = i; j < n - dd + 1; j++) {
                        maxJobDiff = Math.max(maxJobDiff, jobDifficulty[j]);
                        dp[i][dd] = Math.min(dp[i][dd], maxJobDiff + dp[j + 1][dd - 1]);
                    }
                }
            }
        }

        return dp[0][d];
    }
}