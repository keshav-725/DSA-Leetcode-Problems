class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        while(left<right && nums[left]==list.get(2)) left++;
                        while(left<right && nums[right]==list.get(3)) right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
                while(j+1<nums.length && nums[j]==nums[j+1]) j++;
            }
            while(i+1<nums.length && nums[i]==nums[i+1]) i++;
        }
        return ans;
    }
}