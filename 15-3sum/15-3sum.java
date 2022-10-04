class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            int rem = 0-nums[i];
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]==rem){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    while(j<k && nums[j]==temp.get(1)) j++;
                    while(j<k && nums[k]==temp.get(2)) k--;
                }
                else if(nums[j]+nums[k]<rem){
                    j++;
                }
                else{
                    k--;
                }
            }
            while(i<nums.length-2 && nums[i]==nums[i+1]) i++;
        }
        return ans;
    }
}