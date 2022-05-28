class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int res1=0,i=0;
        for(;i<len;i++){
            res1 = res1^i;
            res1 = res1^nums[i];
        }
        res1 = res1 ^ i;
        return res1;
    }
}