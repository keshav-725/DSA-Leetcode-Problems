class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        Arrays.sort(nums); // sort the array first
        dfs(nums, visited, permutation, resultSet);
        return resultSet;
    }
    
    public void dfs(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> resultSet) {
        // find one permutation, add into the resultSet, exit of recursion
        if (permutation.size() == nums.length) {
            resultSet.add(new ArrayList<>(permutation));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // number is the same as the previous one, avoid reusing it
            if (i > 0 && visited[i - 1] == false && nums[i] == nums[i - 1]) {
                continue;
            }
            
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, resultSet);
            // Backtracking, modify the visited status
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}