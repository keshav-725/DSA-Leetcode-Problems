class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int ans=1,count=1;
        for(int i=0;i<nums.length-1;i++){
            while(i+1<nums.length && nums[i]==nums[i+1]) i++;
            if(i+1<nums.length && nums[i]+1==nums[i+1]) count++;
            else count=1;
            ans = Math.max(ans,count);
        }
        return ans;
    }
}