class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int maxDiff = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int prev = map.get(nums[i]);
                maxDiff = Math.min(maxDiff,(i-prev));
                map.put(nums[i],i);
            }else{
                map.put(nums[i],i);
            }
        }
        if(maxDiff<=k) return true;
        return false;
    }
}