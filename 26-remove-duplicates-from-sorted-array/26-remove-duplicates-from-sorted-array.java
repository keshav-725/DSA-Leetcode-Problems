class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int start = 0,end=1;
        while(end<nums.length){
            int s = nums[start];
            while(end<nums.length && nums[end]==s){
                end++;
            }
            if(start<nums.length-1 && end<nums.length){
                start++;
                nums[start]=nums[end];
                count++;
            }
        }
        return count+1;
    }
}