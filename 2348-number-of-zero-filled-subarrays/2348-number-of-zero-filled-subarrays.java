class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long sum=0;
        int i=0;
        while(i<nums.length){
            long len = 0;
            while(i<nums.length && nums[i]==0){
                i++;len++;
            }
            sum += ((len*(len+1))/2);
            i++;
        }
        return sum;
    }
}