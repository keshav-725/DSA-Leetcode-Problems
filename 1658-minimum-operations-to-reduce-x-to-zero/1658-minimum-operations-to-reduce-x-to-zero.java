class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(x>sum) return -1;
        if(sum==x) return nums.length;
        int rem = sum-x,j=0;
        int nsum=0,max=0;
        for(int i=0;i<nums.length;i++){
            nsum+=nums[i];
            while(nsum>rem){
                nsum-=nums[j];
                j++;
            }
            if(nsum==rem){
                max=Math.max(max,i-j+1);
            }
        }
        //System.out.println(max);
        return max==0?-1:nums.length-max;
    }
}