class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length-1, n = grid[0].length-1;
        if (grid[m][n] > 0) return 0;
        grid[m][n] = -1;
        for (int r=m, t, u; r > 0; r--) {
            int[] row = grid[r], up = grid[r-1];
            for (int c=n, j=c-1, l; c > 0; c=j, j--) {
                if ((t = row[c]) >  0) continue;
                if ((u =  up[c]) <= 0)  up[c] = u + t;
                if ((l = row[j]) <= 0) row[j] = l + t;
            }
            if ((t = row[0]) <= 0 && (u = up[0]) <= 0) up[0] = u + t;
        }
        int[] row = grid[0];
        int ans = row[n];
        if (ans > 0) ans = 0;
        for (int c=n-1; c >= 0; c--) {
            int t = row[c];
            ans = t > 0 ? 0 : ans + t;
        }
        return -ans;
    }
}