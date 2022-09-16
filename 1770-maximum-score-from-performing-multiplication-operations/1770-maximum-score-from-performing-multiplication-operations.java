class Solution {
    public static int maximumScore(int[] nums, int[] multipliers) {
		int m = multipliers.length;
		int[][] mem = new int[m][m];
		for (int[] arr : mem) Arrays.fill(arr, Integer.MIN_VALUE);
		return maximumScoreRec(nums, multipliers, 0, 0, mem);
	}
    
    private static int maximumScoreRec(int[] nums, int[] multipliers, int i, int j, int[][] mem) {
        if (j == multipliers.length) return 0;
        if (mem[i][j] != Integer.MIN_VALUE) return mem[i][j];
        int end = nums.length - 1 - (j - i);     //this part is the only tricky part in the problem.
       return mem[i][j] = Math.max(
            nums[i] * multipliers[j] + maximumScoreRec(nums, multipliers, i + 1, j + 1, mem),
            nums[end] * multipliers[j] + maximumScoreRec(nums, multipliers, i, j + 1, mem)
        );
    }
}