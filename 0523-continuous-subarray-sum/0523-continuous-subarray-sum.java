class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Long,Integer> map = new HashMap<>();
        long sum = 0;
        for(int i = 0; i < nums.length ; i++){
            sum += nums[i]%k;
            sum = sum%k;
            if(sum == 0 && i!= 0){
                return true;
            }
            if(map.containsKey(sum)){
                int j = map.get(sum);
                if(i-j >= 2){
                    return true;
                }
            }else{
                map.put(sum,i);
            }
        }
        return false;
    }
}