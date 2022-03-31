class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int remtarget = target - (nums[i]+nums[j]);
                int left = j+1;
                int right = n-1;
                while(left<right){
                    int lrsum = nums[left] + nums[right];
                    if(lrsum<remtarget){
                        left++;
                    }else if(lrsum>remtarget){
                        right--;
                    }else{
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        
                        res.add(list);
                        
                        while(left<right && nums[left]==list.get(2)) left++;
                        while(left<right && nums[right]==list.get(3)) right--;
                    }
                }
                while(j+1<n && nums[j+1]==nums[j]) j++;
            }    
            while(i+1<n && nums[i+1]==nums[i]) i++;
        }
        return res;
    }
}