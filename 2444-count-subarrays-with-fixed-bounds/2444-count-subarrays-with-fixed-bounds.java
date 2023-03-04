class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res=0;
        int n=nums.length;
        int imin=-1,imax=-1,st=0;
        for(int i=0;i<n;i++){
            if(nums[i]<minK || nums[i]>maxK){
                imin=imax=-1;
                st=i+1;
            }
            if(nums[i]==minK){
                imin=i;
            }
            if(nums[i]==maxK){
                imax=i;
            }
            // find the min b/w imin and imax
            int k = Math.min(imin,imax);
            // add the max with res
            res=res+Math.max(0L,k-st+1);
        }
        return res;
    }
}