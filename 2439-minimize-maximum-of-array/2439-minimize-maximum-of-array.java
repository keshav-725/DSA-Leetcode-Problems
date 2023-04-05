class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum=nums[0];
        long res = 0;
        ArrayList<Long> list = new ArrayList<>();
        list.add((long)nums[0]);
        for(int i=1;i<nums.length;i++){
            sum += nums[i];
            list.add(sum);
        }
        for(int i=0;i<nums.length;i++){
            long curr = (long)Math.ceil(list.get(i)*1.0/(i+1));
            res = Math.max(res,curr);
        }
        return (int)res;
    }
}