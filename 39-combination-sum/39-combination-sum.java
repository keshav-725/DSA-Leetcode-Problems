class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSumHelper(candidates,target,ans,list,0,0);
        return ans;
    }
    public void combinationSumHelper(int[] candidates, int target,List<List<Integer>> ans,List<Integer> list,int sum,int idx){
        if(sum>target) return;
        if(sum == target){
            ans.add(new ArrayList<>(list));
            return;
            
        }
        for(int i=idx;i<candidates.length;i++){
            list.add(candidates[i]);
            combinationSumHelper(candidates,target,ans,list,sum+candidates[i],i);
            list.remove(list.size()-1);
        }
    }
}