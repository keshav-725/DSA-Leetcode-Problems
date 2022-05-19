class Solution {
    public boolean canJump(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int num = i + nums[i];
            max = Math.max(max,num);
            if(max<=i){
                if(i==nums.length-1) return true;
                else return false;
            }
        }
        return true;
    }
}