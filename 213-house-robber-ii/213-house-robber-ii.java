class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robs(nums, 0, nums.length-1), robs(nums, 1, nums.length));
    }
    
    private int robs(int[] nums, int st, int end){
        int prevTwo = 0, prevOne = 0, Max = 0;
        for(int i=st;i<end;i++){
            Max = Math.max(prevTwo + nums[i], prevOne);
            prevTwo = prevOne;
            prevOne = Max;
        }
        return Max;
    }
}