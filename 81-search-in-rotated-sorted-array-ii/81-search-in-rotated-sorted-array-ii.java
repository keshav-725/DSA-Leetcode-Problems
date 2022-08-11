class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            
            //left is sorted
            if(nums[mid]==target) return true;
            if(nums[left]==nums[mid] && nums[mid]==nums[right]){
                left++;
                right--;
            }
            else if(nums[mid]>=nums[left]){
                if(target>=nums[left] && target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            //right is sorted
            else if(nums[mid]<=nums[right]){
                if(target>nums[mid] && target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}