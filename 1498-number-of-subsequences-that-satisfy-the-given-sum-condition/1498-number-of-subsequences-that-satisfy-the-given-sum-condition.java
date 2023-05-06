class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod=1000000007;
        Arrays.sort(nums);
        int ans=0;
        int pow[]=new int[nums.length];
        pow[0]=1;
        for(int i=1;i<pow.length;i++){
            pow[i]=(2*(pow[i-1])%mod);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>target/2)
                continue;
            int indxOfmax=findIndx(nums,target-nums[i]);
            int temp= pow[indxOfmax-i];
            ans+= (temp%mod);
            ans%=mod;
        }
        return ans;
    }
    public int findIndx(int[] nums, int target){
        int low=0,high=nums.length-1;
        int indx=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<=target){
                indx=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return indx;
    }
}