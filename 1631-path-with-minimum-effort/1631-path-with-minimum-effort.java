class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
public int minimumEffortPath(int[][] heights) {
	var r = heights.length;
	var c = heights[0].length;
	var low = 0;
	var high = Integer.MAX_VALUE;
	var min = high;

	while (low <= high) {
		var mid = low + (high - low) / 2;
		var visited = new boolean[r][c];
		dfs(0, 0, heights, visited, mid);
		if (visited[r - 1][c - 1]) {
			high = mid - 1;
			min = Math.min(min, mid);
		} else {
			low = mid + 1;
		}
	}
	return min;
}

private void dfs(int i, int j, int[][] heights, boolean[][] visited, int mid) {
	visited[i][j] = true;
	for (var dir : DIRS) {
		var nextI = i + dir[0];
		var nextJ = j + dir[1];
		if (nextI >= 0 && nextI < heights.length &&
		    nextJ >= 0 && nextJ < heights[0].length &&
			!visited[nextI][nextJ] &&
			Math.abs(heights[i][j] - heights[nextI][nextJ]) <= mid)
				dfs(nextI, nextJ, heights, visited, mid);
	}
}
}