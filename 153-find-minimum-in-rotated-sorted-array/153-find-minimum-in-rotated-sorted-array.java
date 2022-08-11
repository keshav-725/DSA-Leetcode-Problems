class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(mid>0 && mid+1<nums.length && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            else if(mid>0 && mid+1<nums.length && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
                return nums[mid];
            }
            else if(nums[mid]>nums[right]){
                left = mid+1;
            }
            else if(nums[mid]<nums[left]){
                right = mid-1;
            }else{
                break;
            }
        }
        return nums[left];
    }
}