class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median;
        if(n%2==0){
            median = (nums[n/2]+nums[n/2-1])/2;
        }else{
            median = nums[n/2];
        }
        int moves = 0;
        for(int num : nums){
            moves += Math.abs(median-num);
        }
        return moves;
    }
}