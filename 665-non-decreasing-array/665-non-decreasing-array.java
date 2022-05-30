class Solution {
    public boolean checkPossibility(int[] nums) {
        int inc=-1;
        int dec=-1;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                inc=i;
                dec=i+1;
                count++;
            }
            if(count>1) return false;
        }
        if(inc-1>=0 && dec+1<nums.length){
            if(nums[inc-1]>nums[dec] && nums[inc]>nums[dec+1]) return false;
        }
        return true;
    }
}