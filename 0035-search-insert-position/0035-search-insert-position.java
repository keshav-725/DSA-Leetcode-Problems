class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int pans = nums.length;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target){
                left = mid+1;
            }else{
                pans = mid;
                right = mid-1;
            }
        }
        return pans;
    }
}