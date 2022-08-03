class Solution {
    public int[] buildArray(int[] nums) {
        int []ans = new int[nums.length];
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]+(nums[nums[i]]%n)*n;
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]/n;
        }
        return nums;
    }
}