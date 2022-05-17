class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0,count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            sum += num;
            int div = sum%k;
            if(div<0){
                div+=k;
            }
            if(map.containsKey(div)){
                count += map.get(div);
                //map.put(sum%k,map.get(sum%k)+1);
            }
            map.put(div,map.getOrDefault(div,0)+1);
        }
        return count;
    }
}