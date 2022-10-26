class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     System.out.println(nums[i]);
        // }
        int i = 0;
        while(i<nums.length){
            int left = i+1;
            int right = nums.length-1;
            
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                // System.out.println(" i-> "+i+" left-> "+left+" right-> "+right+" sum-> "+sum);
                if(sum==0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    ans.add(res);
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]) left++;
                    while(left<right && nums[right]==nums[right+1]) right--;
                }else if(sum<0){
                    left++;
                    while(left<right && nums[left]==nums[left-1]) left++;
                }else{
                    right--;
                    while(left<right && nums[right]==nums[right+1]) right--;
                }
            }
            i++;
            while(i<nums.length && nums[i]==nums[i-1]) i++;
        }
        return ans;
    }
}