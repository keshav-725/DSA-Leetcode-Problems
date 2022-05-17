class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(map.containsKey(num)){
                ans.add(num);
            }else{
                map.put(num,1);
            }
        }
        return ans;
    }
}