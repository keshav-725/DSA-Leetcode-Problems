class Solution {
    public int maxArea(int[] nums) {
        int left=0,right=nums.length-1,ans=0;
        while(left<right){
            ans = Math.max(ans,((right-left)*Math.min(nums[right],nums[left])));
            if(nums[left]<nums[right]){
                left++;
            }else{
                right--;
            }
                           
        }
        return ans;
    }
}