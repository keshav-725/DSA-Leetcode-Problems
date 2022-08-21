class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getPermutation(nums,ans,list,0);
        return ans;
    }
    public void getPermutation(int []nums,List<List<Integer>> ans,List<Integer> list,int idx){
        if(idx==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                getPermutation(nums,ans,list,idx+1);
                list.remove(list.size()-1);
            }
            
        }
    }
}