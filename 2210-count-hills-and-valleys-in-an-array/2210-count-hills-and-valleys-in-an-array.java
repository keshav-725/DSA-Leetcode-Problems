class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        for(int i=1;i<nums.length-1;i++){
            int isleft=Integer.MAX_VALUE;
            int isright=Integer.MAX_VALUE;
            int lidx=i-1;
            int ridx=i+1;
            while(lidx>=0){
                if(nums[lidx]!=nums[i]){
                    isleft=nums[lidx];
                    break;
                }
                lidx--;
            }
            while(ridx<nums.length){
                if(nums[ridx]!=nums[i]){
                    isright=nums[ridx];
                    break;
                }
                ridx++;
            }
            if(isleft!=Integer.MAX_VALUE && isright!=Integer.MAX_VALUE && isleft<nums[i] && isright<nums[i]){
                count++;
            }
            if(isleft!=Integer.MAX_VALUE && isright!=Integer.MAX_VALUE && isleft>nums[i] && isright>nums[i]){
                count++;
            }
            while(i+1<nums.length && nums[i]==nums[i+1]){
                i++;
            }
        }
        return count;
    }
}