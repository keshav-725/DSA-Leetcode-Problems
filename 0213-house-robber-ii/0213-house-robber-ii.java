class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }
    public int rob(int []nums,int st,int en){
        
        int prevtwo=0,prevone=0,max=0;
        for(int i=st;i<en;i++){
            max = Math.max(prevtwo+nums[i],prevone);
            prevtwo = prevone;
            prevone = max;
        }
        return max;
    }
}