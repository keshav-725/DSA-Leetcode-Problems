class Solution {
    public int maxArea(int[] nums) {
        int i=0,j=nums.length-1;
        int max = Integer.MIN_VALUE;
        while(i<j){
            int min = Math.min(nums[i],nums[j]);
            max = Math.max(max,(min*(j-i)));
            if(nums[i]<nums[j]){
                i++;
            }else if(nums[i]>nums[j]){
                j--;
            }else{
                max = Math.max(max,Math.min(nums[i+1],nums[j])*(i-j-1));
                max = Math.max(max,Math.min(nums[i],nums[j-1])*(i-j-1));
                i++;
                j--;
            }
        }
        return max;
    }
}