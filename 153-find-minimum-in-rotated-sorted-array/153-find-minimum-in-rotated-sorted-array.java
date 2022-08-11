class Solution {
    public boolean isMinimum(int []nums,int mid){
        int lval = (mid-1)<0?Integer.MAX_VALUE : nums[mid-1];
        int rval = (mid+1)>=nums.length ? Integer.MAX_VALUE : nums[mid+1];
        if(nums[mid]<lval && nums[mid]<rval) return true;
        return false;
    }
    public boolean isMaximum(int []nums,int mid){
        int lval = (mid-1)<0?Integer.MIN_VALUE : nums[mid-1];
        int rval = (mid+1)>=nums.length ? Integer.MIN_VALUE : nums[mid+1];
        if(nums[mid]>lval && nums[mid]>rval) return true;
        return false;
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(isMinimum(nums,mid)) return nums[mid];
            if(isMaximum(nums,mid)) return nums[mid+1];
            if(nums[mid]>nums[right]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return nums[left];
    }
}