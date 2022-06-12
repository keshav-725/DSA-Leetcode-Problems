class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> sub = new HashSet<>();

		int maxSum = 0;
		int currentSum = 0;

		int addIndex = 0;
		int deleteIndex = 0;
		while (addIndex < nums.length) {
			int current = nums[addIndex];

			while (sub.contains(current)) {
				sub.remove(nums[deleteIndex]);
				currentSum -= nums[deleteIndex];
				deleteIndex++;
			} 

			sub.add(current);
			currentSum += current;

			maxSum = Math.max(currentSum, maxSum);

			addIndex++;
		}

		return maxSum;
    }
}