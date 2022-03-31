class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int tl=0,ml=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                tl++;
            }else{
                ml = Math.max(tl,ml);
                tl=0;
            }
        }
        ml = Math.max(tl,ml);
        return ml;
    }
}