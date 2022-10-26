class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        
        while(left<right){
            int lval = nums[left];
            int rval = nums[right];
            
            if(lval+rval == target){
                return new int[]{left+1,right+1};
            }else if(lval+rval < target){
                left++;
                while(left<right && nums[left]==nums[left-1]) left++;
            }else{
                right--;
                while(right > left && nums[right]==nums[right+1]) right--;
            }
            
        }
        return new int[]{-1,-1};
    }
}