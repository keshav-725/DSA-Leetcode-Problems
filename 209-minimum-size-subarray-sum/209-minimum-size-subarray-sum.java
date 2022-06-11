class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int count=Integer.MAX_VALUE,sum=0,j=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum>=target){
                count= Math.min(count,i-j+1);
            }
            while(sum>=target){
                sum-=nums[j];
                j++;
                if(sum>=target){
                    count= Math.min(count,i-j+1);
                }
            }
        }
        return count==Integer.MAX_VALUE?0:count;
    }
}