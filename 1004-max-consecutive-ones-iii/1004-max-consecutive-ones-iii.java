class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0,ml=0;
        int onecount=0;
        int zerocount=0;
        while(i<nums.length){
            int num = nums[i];

            if(num==1) onecount++;
            else zerocount++;

            if(zerocount<=k){
                ml = Math.max(ml,i-j+1);
            }
            while(j<i && zerocount>k){
                if(nums[j]==1) onecount--;
                else zerocount--;
                j++;
            }
            i++;
        }
        return ml;
    }
}