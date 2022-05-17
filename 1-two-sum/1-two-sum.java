class Solution {
    public int[] twoSum(int[] nums, int target) {
        int []result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(map.containsKey(target-num)){
                result[1]=i;
                result[0]=map.get(target-num);
                return result;
            }
            map.put(num,i);
        }
        return result;
    }
}