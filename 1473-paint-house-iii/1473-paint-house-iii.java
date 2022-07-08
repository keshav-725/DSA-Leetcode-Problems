class Solution {
    
    int[] houses;
    int[][] cost;
    int m, n, target;
    int MAX_VALUE = 1000001;
	int memo[][][] = new int[101][21][101];

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;

        int ans = helper(0, 0, 0);

        return ans == MAX_VALUE ? -1 : ans;
    }

    public int helper(int i, int prevCol, int groups) {
        if(groups > target)
            return MAX_VALUE;

        if(i == m) 
            return groups == target ? 0 : MAX_VALUE;
			
		if(memo[i][prevCol][groups] != 0)
			return memo[i][prevCol][groups];
        
        int ans = MAX_VALUE;

        if(houses[i] != 0)
            ans = Math.min(ans, helper(i+1, houses[i], houses[i] == prevCol ? groups : groups + 1)); 

        else 
            for(int j = 0; j < n; j++)
                ans = Math.min(ans, cost[i][j] + helper(i+1, j+1, prevCol == j+1 ? groups: groups + 1)); 
        
        return memo[i][prevCol][groups] = ans;
    }
}