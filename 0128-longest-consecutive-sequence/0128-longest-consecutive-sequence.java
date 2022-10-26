class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(map.containsKey(num-1)){
                map.put(num,map.get(num-1)+1);
            }else{
                map.put(num,1);
            }
            ans = Math.max(ans,map.get(num));
        }
        return ans;
    }
}