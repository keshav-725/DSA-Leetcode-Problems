class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0,end=0;
        while(end<nums.length){
            while(end<nums.length && nums[end]==0){
                end++;
            }
            while(start<end && nums[start]!=0){
                start++;
            }
            if(start<nums.length && end<nums.length){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
            start++;
            end++;
        }
    }
}